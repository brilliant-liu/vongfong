package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: liukj
 * @date: 2020/5/15
 * @description：
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCenter2Application.class,args);
    }
}
