package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: liukj
 * @date: 2020/5/19
 * @description：
 */
@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrix
public class OpenFeignCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignCenterApplication.class,args);
    }
}
