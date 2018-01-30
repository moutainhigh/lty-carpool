package com.lantaiyuan.carpool.match;

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
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.common","com.lantaiyuan.carpool.match"})
@Slf4j
public class MatchApplication {
    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(MatchApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
