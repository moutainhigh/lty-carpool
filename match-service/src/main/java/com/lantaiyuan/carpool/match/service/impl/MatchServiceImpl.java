package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.match.channel.SubscribeChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MatchServiceImpl implements IMatchService {
    @Override
    @StreamListener(SubscribeChannel.SUBSCRIBE)
    public void match(String msg) {
        log.info(msg);
        System.out.println(msg);
    }
}
