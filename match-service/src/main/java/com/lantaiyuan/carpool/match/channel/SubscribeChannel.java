package com.lantaiyuan.carpool.match.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding
public interface SubscribeChannel {
    String SUBSCRIBE = "subscribe";

    @Input(SUBSCRIBE)
    SubscribableChannel subscribe();
}
