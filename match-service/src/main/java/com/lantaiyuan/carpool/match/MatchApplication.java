package com.lantaiyuan.carpool.match;

import com.lantaiyuan.carpool.match.channel.SubscribeChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/10$ 11:47$
 * @description:
 */
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.dao","com.lantaiyuan.carpool.common.domain","com.lantaiyuan.carpool.match"})
@Slf4j
@EnableBinding({
        SubscribeChannel.class
})
public class MatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatchApplication.class, args);
    }
}
