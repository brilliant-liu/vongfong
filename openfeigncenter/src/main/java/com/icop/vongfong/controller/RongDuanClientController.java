package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.HystrixClient2Services;
import com.icop.vongfong.services.RongDuanServices;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/21
 * @description：
 */

@RestController
@Slf4j
public class RongDuanClientController {

    @Resource
    RongDuanServices hystrixClient2Services;

    @Value("${server.port}")
    private String port;


    @GetMapping("/hystrix/rd/ok")
    public CommonResult services_ok() {
        return hystrixClient2Services.services_ok();
    }

    public CommonResult rongduanFallback(){

        String name = Thread.currentThread().getName();
        return new CommonResult(888,"触发熔断机制！"+name,null);
    }


    @HystrixCommand(fallbackMethod = "rongduanFallback")
    @GetMapping("/hystrix/rd/error")
    public CommonResult services_error() {

        return hystrixClient2Services.services_error();
    }

    /**
     * {@link HystrixCommandProperties} 配置参数内容
     * @return
     */
    /*@HystrixCommand(
            fallbackMethod = "rongduanFallbacks",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "90") // 在时间窗口期失败率到达该阈值时，断开。
            }
    )*/
    @GetMapping("/hystrix/rd/timeout/{id}")
    public CommonResult services_timeout(@PathVariable("id") Long id) {
        /*if(id>10000){
            throw new RuntimeException("会触发熔断吗？？？？");
        }*/
        return hystrixClient2Services.services_timeout(id);
    }

    public CommonResult rongduanFallbacks(Long id){

        String name = Thread.currentThread().getName();
        return new CommonResult(999,id+"触发熔断机制！"+name,null);
    }
}
