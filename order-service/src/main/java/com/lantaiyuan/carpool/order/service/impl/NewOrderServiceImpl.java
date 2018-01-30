package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.OrderRepository;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.order.channel.PublishChannel;
import com.lantaiyuan.carpool.order.domain.request.NewOrderRequest;
import com.lantaiyuan.carpool.order.service.INewOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:54$
 * @description:
 */
@Service
@Slf4j
public class NewOrderServiceImpl implements INewOrderService {
    @Autowired
    PublishChannel publishChannel;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public int newOrder(NewOrderRequest newOrderRequest) {
        Order order = newOrderRequest.getOrder();
        boolean alreadyPaid=order.getAlreadyPaid();
        if(alreadyPaid){
            if(canAdd(order)){
//                orderRepository.save(order);
                Message<Order> msg = MessageBuilder.withPayload(order).build();
                publishChannel.publish().send(msg);
                return ResultCodeEnum.SUCCESS.getValue();
            }else {
                return ResultCodeEnum.ORDER_INVALIDATE.getValue();
            }
        }else{
            if(canAdd(order)){
                return ResultCodeEnum.ORDER_CAN_ADD.getValue();
            }else {
                return ResultCodeEnum.ORDER_INVALIDATE.getValue();
            }
        }
    }

    boolean canAdd(Order order){
        return true;
    }
}
