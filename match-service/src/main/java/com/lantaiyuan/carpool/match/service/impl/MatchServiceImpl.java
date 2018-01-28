package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.match.channel.SubscribeChannel;
import org.springframework.cloud.stream.annotation.StreamListener;

public class MatchServiceImpl implements IMatchService {
    @Override
    @StreamListener(SubscribeChannel.SUBSCRIBE)
    public void match(String msg) {

    }
}
