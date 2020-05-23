package com.icop.vongfong.services;

import com.icop.vongfong.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author: liukj
 * @date: 2020/5/19
 * @description：
 */
@Service
@Slf4j
public class PaymentServices {

    public CommonResult payment_ok(){
        Thread thread = Thread.currentThread();
        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，时间：{2}",thread.getId(),thread.getName(), LocalDateTime.now());
        log.info(result);
        return new CommonResult(200,"调用成功！",result);
    }

    /*@HystrixCommand(fallbackMethod = "paymentTimeoutHandler" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    public CommonResult payment_error() {
        Thread thread = Thread.currentThread();
        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，时间：{2}",thread.getId(),thread.getName(), LocalDateTime.now());
        log.info(result);
        //int i= 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return new CommonResult(400,"调用失败！",result);
    }

    public CommonResult paymentTimeoutHandler(){
        return new CommonResult(201,"paymentTimeoutHandler:等待超时，请稍后再试！",null);
    }



}
