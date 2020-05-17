package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: liukj
 * @date: 2020/5/15
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayCenter2Application {
    public static void main(String[] args) {
        SpringApplication.run(PayCenter2Application.class,args);
    }
}
