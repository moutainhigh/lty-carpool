package com.lantaiyuan.carpool.match.channel.hander;

import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
import com.lantaiyuan.carpool.match.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
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
    @StreamListener(MatchSubscribeChannel.SUBSCRIBE)
    public void handleSubscribe(String msg) {
        System.out.println(msg);
        matchService.match(msg);
    }
}
