package com.lantaiyuan.carpool.match.channel.hander;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;
import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
import com.lantaiyuan.carpool.match.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/30$ 9:37$
 * @description: 消息总线事件分发
 */
@Component
public class MatchSubscribeHandler {
    @Autowired
    IMatchService matchService;
    /**
     * 监听取消请求事件，处理请求
     */
    @StreamListener(target=MatchSubscribeChannel.SUBSCRIBE,condition = "headers['contentType']=='com.lantaiyuan.carpool.order.domain.request.CancelRequest'")
    public void handleCancelRequest(@Payload CancelRequest cancelRequest) {
        matchService.matchCancel(cancelRequest);
    }
    /**
     * 监听新订单请求事件，处理请求
     */
    @StreamListener(target=MatchSubscribeChannel.SUBSCRIBE,condition = "headers['contentType']=='com.lantaiyuan.carpool.common.domain.Order'")
    public void handleNewOrder(@Payload Order order) {
        matchService.matchOrder(order);
    }
}
