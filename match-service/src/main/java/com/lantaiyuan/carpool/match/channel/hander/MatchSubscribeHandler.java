package com.lantaiyuan.carpool.match.channel.hander;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.order.domain.request.CancelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/30$ 9:37$
 * @description:
 */
@Component
public class MatchSubscribeHandler {
    @Autowired
    IMatchService matchService;
    @StreamListener(target=MatchSubscribeChannel.SUBSCRIBE,condition = "headers['contentType']=='CancelRequest'")
    public void handleCancelRequest(@Payload CancelRequest cancelRequest) {
        System.out.println(cancelRequest.toString());
        matchService.matchCancel(cancelRequest);
    }

    @StreamListener(target=MatchSubscribeChannel.SUBSCRIBE,condition = "headers['contentType']=='Order'")
    public void handleNewOrder(@Payload Order order) {
        System.out.println(order.toString());
        matchService.matchOrder(order);
    }
}
