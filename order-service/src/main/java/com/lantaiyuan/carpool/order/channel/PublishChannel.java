package com.lantaiyuan.carpool.order.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author qiuwanshan
 * @Description: 实际上是不需要加@Component的,但是如果不加,在@AutoWire 的时候,Idea会提示没有这个bean,所以加上.
 */
@Component
public interface PublishChannel {
    String PUBLISH = "publish";

    @Output(PUBLISH)
    MessageChannel publish();
}
