package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.HystrixClient2Services;
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

@RestController
@Slf4j
public class HystrixClient2Controller {

    @Resource
    HystrixClient2Services hystrixClient2Services;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hystrix/client2/ok")
    public CommonResult services_ok() {
        return hystrixClient2Services.services_ok();
    }

    @GetMapping("/hystrix/client2/error")
    public CommonResult services_error() {
        return hystrixClient2Services.services_error();
    }

    @GetMapping("/hystrix/client2/timeout/{id}")
    public CommonResult services_timeout(@PathVariable("id") Long id) {
        return hystrixClient2Services.services_timeout(id);
    }
}
