package com.study.demo.microservice.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate Configuration.
 *
 * @author yangbin
 **/
@Configuration
public class RestTemplateConfig {

    @Autowired private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        // 已集成 HttpClient, 会自动配置 HttpClient.
        return builder.build();
    }
}
