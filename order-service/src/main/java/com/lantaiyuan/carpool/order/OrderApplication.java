package com.lantaiyuan.carpool.order;

import com.lantaiyuan.carpool.order.channel.PublishChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2017/12/27$ 14:03$
 * @description:订单
 */
@SpringBootApplication(scanBasePackages={"com.lantaiyuan.carpool.common.common","com.lantaiyuan.carpool.order"})
@Slf4j
@EnableBinding({
        PublishChannel.class
})
public class OrderApplication {
    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(OrderApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();
        log.info("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            log.info(bn);
        }
    }
}
