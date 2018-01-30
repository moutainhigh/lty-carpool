package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;


/**
 * @author qiuwanshan
 */
@Service
@Slf4j
public class MatchServiceImpl implements IMatchService {
    @Override
    public void match(String msg) {
    }
}
