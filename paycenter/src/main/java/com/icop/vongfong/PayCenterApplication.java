package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayCenterApplication.class,args);
    }
}