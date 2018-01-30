package com.lantaiyuan.carpool.match.channel.hander;

import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
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
    @StreamListener(MatchSubscribeChannel.SUBSCRIBE)
    public void handleSubscribe(String msg) {
        System.out.println(msg);
    }
}
