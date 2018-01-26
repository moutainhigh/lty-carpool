package com.lantaiyuan.carpool.match;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 14:59$
 * @description:
 */
@Component
public class LocalRestTemplate {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
