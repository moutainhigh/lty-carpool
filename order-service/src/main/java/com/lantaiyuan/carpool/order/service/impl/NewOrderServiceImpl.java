package com.lantaiyuan.carpool.order.service.impl;

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
    @Override
    public int newOrder(NewOrderRequest newOrderRequest) {
        Message<String> msg = MessageBuilder.withPayload("newOrder").build();
        publishChannel.publish().send(msg);
        return 0;
    }
}
