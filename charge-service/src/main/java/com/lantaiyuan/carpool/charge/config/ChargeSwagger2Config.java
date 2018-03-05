package com.lantaiyuan.carpool.charge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 15:33$
 * @description:
 */
@Configuration
@EnableSwagger2
public class ChargeSwagger2Config {
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("charge")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lantaiyuan"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("charge APIs")
                .description("charge API")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
