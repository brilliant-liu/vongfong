package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.ServicesInterface;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/26
 * @description：
 */
@RestController
public class ConfigClientController {

    @Resource
    ServicesInterface servicesInterface;

    @Value("${server.port}")
    private String port;


    @GetMapping("/configclient1/rd/ok")
    public CommonResult services_ok() {
        return servicesInterface.services_ok();
    }

    public CommonResult rongduanFallback(){

        String name = Thread.currentThread().getName();
        return new CommonResult(888,"触发熔断机制！"+name,null);
    }


    @HystrixCommand(fallbackMethod = "rongduanFallback")
    @GetMapping("/configclient1/rd/error")
    public CommonResult services_error() {

        return servicesInterface.services_error();
    }

    /**
     * {@link HystrixCommandProperties} 配置参数内容
     * @return
     */
    @GetMapping("/configclient1/rd/timeout/{id}")
    public CommonResult services_timeout(@PathVariable("id") Long id) {
        /*if(id>10000){
            throw new RuntimeException("会触发熔断吗？？？？");
        }*/
        return servicesInterface.services_timeout(id);
    }

    public CommonResult rongduanFallbacks(Long id){

        String name = Thread.currentThread().getName();
        return new CommonResult(999,id+"触发熔断机制！"+name,null);
    }
}
