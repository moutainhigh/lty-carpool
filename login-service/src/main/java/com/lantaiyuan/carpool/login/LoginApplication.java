package com.lantaiyuan.carpool.login;

import com.lantaiyuan.carpool.common.CommonApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2017/12/27$ 14:03$
 * @description:用户进入
 */
@SpringBootApplication(scanBasePackages="com.lantaiyuan.carpool")
@Slf4j
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}
