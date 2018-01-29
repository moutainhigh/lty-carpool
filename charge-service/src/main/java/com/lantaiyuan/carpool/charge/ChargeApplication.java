package com.lantaiyuan.carpool.charge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2017/12/27$ 14:03$
 * @description:计费
 */
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.dao","com.lantaiyuan.carpool.common.domain","com.lantaiyuan.carpool.charge"})
@Slf4j
public class ChargeApplication {
    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(ChargeApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
