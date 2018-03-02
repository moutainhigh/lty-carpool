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
 * @description:
 */
@Service
@ImportResource("spring/vesta-service-sample.xml")
@Slf4j
public class NewOrderServiceImpl implements INewOrderService {
    final double MIN_ORDER_SIMILAR=80d;
    @Autowired
    private IOrderService orderService;
    @Resource(name="redisTemplate")
    private RedisTemplate localRedisTemplate;
    @Autowired
    PublishChannel publishChannel;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IdService idService;

    @Override
    public int newOrder(NewOrderRequest newOrderRequest) {
        Order order = newOrderRequest.getOrder();
        boolean alreadyPaid = order.getAlreadyPaid();
        /**
         * 已支付，则撮合订单或加入线路
         */
        if (alreadyPaid) {
            /**
             * 如果订单合适加入
             */
            if (canAdd(order)) {
                //保存订单到sql
                saveOrder2SQL(order);
                Message<Order> msg = MessageBuilder.withPayload(order).setHeader("contentType", order.getClass().getCanonicalName()).build();
                publishChannel.publish().send(msg);
                return ResultCodeEnum.SUCCESS.getValue();
            }
            /**
             * 订单不合适加入
             */
            else {
                return ResultCodeEnum.ORDER_INVALIDATE.getValue();
            }
        }
        /**
         * 未支付，则说明是查询是否合适加入某条线路
         */
        else {
            if (canAdd(order)) {
                return ResultCodeEnum.ORDER_CAN_ADD.getValue();
            } else {
                return ResultCodeEnum.ORDER_INVALIDATE.getValue();
            }
        }
    }

    /**
     * 判断订单能否合适加入
     *
     * @param order
     * @return
     */
    private boolean canAdd(Order order) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        long lineId=order.getLineId();
        Set<Long> orderIds = linePool.get(lineId);
        if(orderIds==null){
            return false;
        }
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
