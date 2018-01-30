package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.common.OrderStatusEnum;
import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.OrderRepository;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.order.channel.PublishChannel;
import com.lantaiyuan.carpool.order.domain.request.CancelRequest;
import com.lantaiyuan.carpool.order.service.ICancelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:53$
 * @description:
 */
@Service
@Slf4j
public class CancelServiceImpl implements ICancelService {
    @Autowired
    PublishChannel publishChannel;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public int cancel(CancelRequest cancelRequest) {
        if(canCancel(cancelRequest)){
            updateOrder(cancelRequest);
            Message<CancelRequest> msg = MessageBuilder.withPayload(cancelRequest).build();
            publishChannel.publish().send(msg);
            return ResultCodeEnum.SUCCESS.getValue();
        }else{
            return ResultCodeEnum.ORDER_CAN_NOT_CANCEL.getValue();
        }
    }
    void updateOrder(CancelRequest cancelRequest){
        Order order= new Order();
        order.setOrderStatus(OrderStatusEnum.CANCEL.getValue());
//        orderRepository.save(order);
    }
    boolean canCancel(CancelRequest cancelRequest){
        return true;
    }

}
