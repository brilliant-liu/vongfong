package com.icop.vongfong.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
