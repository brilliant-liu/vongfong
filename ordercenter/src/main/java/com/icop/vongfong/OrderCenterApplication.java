package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderCenterApplication.class,args);
    }
}
