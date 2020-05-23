package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.HystrixClientServices;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
 * @date: 2020/5/20
 * @description：
 */
//@RestController
@Slf4j
@DefaultProperties(defaultFallback = "services_fallback")
public class HystrixClient1Controller {

    @Resource
    HystrixClientServices hystrixClientServices;

    @Value("${server.port}")
    private String port ;

    @GetMapping("/hystrix/client1/ok")
    public CommonResult services_ok(){
        return hystrixClientServices.services_ok();
    }

    @GetMapping("/hystrix/client1/error")
    @HystrixCommand
    public CommonResult services_error(){
        return hystrixClientServices.services_error();
    }

    @GetMapping("/hystrix/client1/timeout/{id}")
    @HystrixCommand
    public CommonResult services_timeout(@PathVariable("id") Long id){
        return hystrixClientServices.services_timeout(id);
    }

    public CommonResult services_fallback(){
        return new CommonResult(200,"服务运行异常！",null);
    }
}
