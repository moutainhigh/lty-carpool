package com.lantaiyuan.carpool.match;

import com.lantaiyuan.carpool.common.CommonApplication;
import com.lantaiyuan.carpool.match.channel.MatchSubscribeChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/10$ 11:47$
 * @description:
 */
@EnableBinding({
        MatchSubscribeChannel.class
})
@SpringBootApplication(scanBasePackages="com.lantaiyuan.carpool")
@Slf4j
public class MatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatchApplication.class, args);
    }
}
