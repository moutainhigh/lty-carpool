package com.lantaiyuan.carpool.common;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 16:43$
 * @description:
 */
@SpringBootApplication
@Slf4j
public class CommonApplication {
    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(CommonApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
