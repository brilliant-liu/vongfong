package com.icop.vongfong.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liukj
 * @date: 2020/5/15
 * @description：
 */
@Configuration
public class ApplicationContentConfig {

    @Bean
    @LoadBalanced // 该注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
