package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.HystrixServices;
import com.icop.vongfong.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author: liukj
 * @date: 2020/5/20
 * @description：
 */
@RestController
@Slf4j
public class HystrixServerController {

    @Resource
    HystrixServices hystrixServices;

    @Value("${server.port}")
    private String port ;

    @GetMapping("/hystrix/services/ok")
    public CommonResult services_ok(){
        Thread thread = Thread.currentThread();
        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，时间：{2}",thread.getId(),thread.getName(), LocalDateTime.now());
        log.info(result);
        return new CommonResult(200,"调用端口："+port+"：hystrix/services/ok",result);
    }

    @GetMapping("/hystrix/services/error")
    public CommonResult services_error(){
       throw new RuntimeException("调用端口："+port+"：/hystrix/services/error");
    }

    @GetMapping("/hystrix/services/timeout/{id}")
    public CommonResult services_timeout(@PathVariable("id") Long id){
        return hystrixServices.services_timeout(id);
    }
}
