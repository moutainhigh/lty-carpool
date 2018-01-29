package com.lantaiyuan.carpool.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2017/12/27$ 14:03$
 * @description:用户进入
 */
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.common","com.lantaiyuan.carpool.login"})
@Slf4j
public class LoginApplication {
    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(LoginApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
