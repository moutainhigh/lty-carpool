package com.lantaiyuan.carpool.match.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author qiuwanshan
 */
public interface MatchSubscribeChannel {
    String SUBSCRIBE = "subscribe";
    /**
     *
     * @return
     */
    @Input(SUBSCRIBE)
    SubscribableChannel subscribe();
}
