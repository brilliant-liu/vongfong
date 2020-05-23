package com.icop.vongfong.services;

import com.icop.vongfong.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * @author: liukj
 * @date: 2020/5/22
 * @description：
 */

@Slf4j
@Component
public class HystrixServices {

    @HystrixCommand(
            fallbackMethod = "rongduanFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"), //请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期,触发熔断后，经过该时间窗口期，可恢复服务访问
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "20") // 在时间窗口期失败率到达该阈值时，断开。
            }
    )
    public CommonResult services_timeout(@PathVariable("id") Long id){

        Thread thread = Thread.currentThread();
        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，地址:{2}",thread.getId(),thread.getName(), "/hystrix/services/timeout/{id}");
        log.info(result);
        if(id>10000){
            throw new RuntimeException("时间大于10000");
        }
        /*try {
            TimeUnit.MILLISECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new CommonResult(200,"调用端口：8004"+"：/hystrix/services/timeout/{id}",result);
    }

    public CommonResult rongduanFallback(Long id){

        String name = Thread.currentThread().getName();
        return new CommonResult(888,"触发熔断机制！"+name,null);
    }
}
