package com.lantaiyuan.carpool.match.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author qiuwanshan
 */
@Component
public interface MatchSubscribeChannel {
    String SUBSCRIBE = "subscribe";
    /**
     *
     * @return
     */
    @Input(SUBSCRIBE)
    SubscribableChannel subscribe();
}
