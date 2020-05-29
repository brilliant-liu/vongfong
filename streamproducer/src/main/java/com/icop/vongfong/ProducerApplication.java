package com.icop.vongfong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

/**
 * @author: liukj
 * @date: 2020/5/28
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableDiscoveryClient
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class,args);
    }

    @Bean
    public MessageChannel outputs(){
        MessageChannel outputs = new PublishSubscribeChannel ();
        return outputs;
    }
}
