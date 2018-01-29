package com.lantaiyuan.carpool.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 15:51$
 * @description:
 */
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.common","com.lantaiyuan.carpool.websocket"})
@Slf4j
public class WebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }
}
