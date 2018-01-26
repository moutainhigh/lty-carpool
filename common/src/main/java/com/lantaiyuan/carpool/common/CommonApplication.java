package com.lantaiyuan.carpool.common;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        SpringApplication.run(CommonApplication.class, args);
    }
}
