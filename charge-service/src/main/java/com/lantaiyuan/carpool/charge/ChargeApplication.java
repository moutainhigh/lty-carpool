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
@SpringBootApplication(scanBasePackages="com.lantaiyuan.carpool")
@Slf4j
public class ChargeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChargeApplication.class, args);
    }
}
