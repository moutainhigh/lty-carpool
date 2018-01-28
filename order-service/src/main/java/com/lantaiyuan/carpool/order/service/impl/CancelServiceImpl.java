package com.lantaiyuan.carpool.order.service.impl;

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
    @Override
    public int cancel(CancelRequest cancelRequest) {
        Message<String> msg = MessageBuilder.withPayload("jh").build();
        publishChannel.publish().send(msg);
        return 0;
    }
}
