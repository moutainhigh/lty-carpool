package com.lantaiyuan.carpool.order;

import com.lantaiyuan.carpool.common.CommonApplication;
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
@SpringBootApplication
@Slf4j
@EnableBinding({
        PublishChannel.class
})
public class OrderApplication {
    public static void main(String[] args) {
        Object[] objects= new Object[2];
        objects[0] = CommonApplication.class;
        objects[1] = OrderApplication.class;
        SpringApplication.run(objects, args);
    }
}
