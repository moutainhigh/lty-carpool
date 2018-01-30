package com.lantaiyuan.carpool.charge;

import com.lantaiyuan.carpool.common.CommonApplication;
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
@SpringBootApplication
@Slf4j
public class ChargeApplication {
    public static void main(String[] args) {
        Object[] objects= new Object[2];
        objects[0] = CommonApplication.class;
        objects[1] = ChargeApplication.class;
        ApplicationContext ctx =SpringApplication.run(objects, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
