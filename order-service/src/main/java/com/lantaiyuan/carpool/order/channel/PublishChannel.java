package com.lantaiyuan.carpool.order.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding
public interface PublishChannel {
    String PUBLISH = "publish";

    @Output(PUBLISH)
    MessageChannel publish();
}
