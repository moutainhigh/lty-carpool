package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.common.constant.RedisPoolKey;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.OrderRepository;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.request.NewOrderRequest;
import com.lantaiyuan.carpool.common.service.IOrderService;
import com.lantaiyuan.carpool.order.channel.PublishChannel;
import com.lantaiyuan.carpool.order.service.INewOrderService;
import com.robert.vesta.service.intf.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:54$
 * @description:新订单实现
 */
@Service
@ImportResource("spring/vesta-service-sample.xml")
@Slf4j
public class NewOrderServiceImpl implements INewOrderService {
    /**
     * 行程最小相似度，相似度最大值Pi**100
     */
    final double MIN_ORDER_SIMILAR=300d;
    @Autowired
    private IOrderService orderService;
    @Resource(name="redisTemplate")
    private RedisTemplate localRedisTemplate;
    /**
     * 消息总线发送通道
     */
    @Autowired
    PublishChannel publishChannel;
    /**
     * 数据库订单信息jpa查询句柄
     */
    @Autowired
    private OrderRepository orderRepository;
    /**
     * 分布式id生成器
     */
    @Autowired
    private IdService idService;

    /**
     * 接受新订单请求
     * @param newOrderRequest
     * @return
     */
    @Override
    public int newOrder(NewOrderRequest newOrderRequest) {
        Order order = newOrderRequest.getOrder();
        boolean alreadyPaid = order.getAlreadyPaid();
        /**
         * 已支付，则撮合订单或加入线路
         */
        if (alreadyPaid) {
            /**
             * 订单中线路id为空或者为0，说明是新订单，否则是加入某条线路
             */
            if(order.getLineId()==null||order.getLineId()==0){
                //保存订单到数据库
                saveOrder2SQL(order);
                //通过消息总线发送新订单信息
                Message<Order> msg = MessageBuilder.withPayload(order).setHeader("contentType", order.getClass().getCanonicalName()).build();
                publishChannel.publish().send(msg);
                return ResultCodeEnum.SUCCESS.getValue();
            }else{
                /**
                 * 如果订单合适加入线路
                 */
                if (canAdd2Line(order)) {
                    //保存订单到数据库
                    saveOrder2SQL(order);
                    //通过消息总线发送新订单信息
                    Message<Order> msg = MessageBuilder.withPayload(order).setHeader("contentType", order.getClass().getCanonicalName()).build();
                    publishChannel.publish().send(msg);
                    return ResultCodeEnum.SUCCESS.getValue();
                }
                /**
                 * 订单不合适加入线路
                 */
                else {
                    return ResultCodeEnum.ORDER_INVALIDATE.getValue();
                }
            }
        }
        /**
         * 未支付，则说明是查询是否合适加入某条线路
         */
        else {
            if (canAdd2Line(order)) {
                return ResultCodeEnum.ORDER_CAN_ADD.getValue();
            } else {
                return ResultCodeEnum.ORDER_INVALIDATE.getValue();
            }
        }
    }

    /**
     * 判断订单能否加入
     * @param order
     * @return
     */
    private boolean canAdd2Line(Order order) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        long lineId=order.getLineId();
        Set<Long> orderIds = linePool.get(lineId);
        //要加入的线路不存在
        if(orderIds==null){
            return false;
        }
        //判断要加入的线路
        for (long orderId:
             orderIds) {
            Order order1 = orderPool.get(orderId);
            if(orderService.similarity(order,order1)>MIN_ORDER_SIMILAR){
                return true;
            }
        }
        return false;
    }

    /**
     * 保存订单到sql
     */
    private void saveOrder2SQL(Order order) {
        Long orderId = idService.genId();
        order.setOrderId(orderId);
        orderRepository.save(order);
    }
}
