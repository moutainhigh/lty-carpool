package com.lantaiyuan.carpool.order;

import com.lantaiyuan.carpool.common.CommonApplication;
import com.lantaiyuan.carpool.order.channel.PublishChannel;
import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2017/12/27$ 14:03$
 * @description:订单
 */
@SpringBootApplication(scanBasePackages="com.lantaiyuan.carpool")
@Slf4j
@EnableBinding({
        PublishChannel.class
})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
