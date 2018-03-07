package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.common.constant.OrderStatusEnum;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.OrderRepository;
import com.lantaiyuan.carpool.common.dao.UserRepository;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;
import com.lantaiyuan.carpool.order.channel.PublishChannel;
import com.lantaiyuan.carpool.order.service.ICancelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:53$
 * @description:取消订单实现
 */
@Service
@Slf4j
public class CancelServiceImpl implements ICancelService {
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
     * 数据库用户信息jps查询句柄
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 取消订单实现
     * @param cancelRequest 取消请求
     * @return 取消结果返回编码
     */
    @Override
    public int cancel(CancelRequest cancelRequest) {
        if(canCancel(cancelRequest)){
            //更新数据库订单信息
            updateOrder(cancelRequest);
            //通过消息总线发送取消订单信息
            Message<CancelRequest> msg = MessageBuilder.withPayload(cancelRequest).setHeader("contentType", cancelRequest.getClass().getCanonicalName()).build();
            publishChannel.publish().send(msg);
            return ResultCodeEnum.SUCCESS.getValue();
        }else{
            return ResultCodeEnum.ORDER_CAN_NOT_CANCEL.getValue();
        }
    }

    /**
     * 更新sql订单信息
     * @param cancelRequest
     */
    void updateOrder(CancelRequest cancelRequest){
        User user=userRepository.findOne(cancelRequest.getUserId());
        Order order=orderRepository.findOne(user.getOrderId());
        order.setOrderStatus(OrderStatusEnum.CANCEL.getValue());
        orderRepository.save(order);
    }

    /**
     * 判断订单能否取消
     * @param cancelRequest
     * @return 默认不能取消订单
     */
    boolean canCancel(CancelRequest cancelRequest){
        return false;
    }

}
