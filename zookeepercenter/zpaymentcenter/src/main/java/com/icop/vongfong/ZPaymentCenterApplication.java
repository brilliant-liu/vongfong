package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: liukj
 * @date: 2020/5/17
 * @description：
 */
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于consul或者zookeeper作为注册中心注册服务
public class ZPaymentCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZPaymentCenterApplication.class,args);
    }
}
