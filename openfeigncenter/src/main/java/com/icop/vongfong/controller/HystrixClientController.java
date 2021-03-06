package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.HystrixClientServices;
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

/**
 *  单个接口进行降级的服务客户端访问入口
 */
//@RestController
@Slf4j
public class HystrixClientController {

    @Resource
    HystrixClientServices hystrixClientServices;

    @Value("${server.port}")
    private String port ;

    @GetMapping("/hystrix/client/ok")
    public CommonResult services_ok(){
        return hystrixClientServices.services_ok();
    }

    @GetMapping("/hystrix/client/error")
    @HystrixCommand(fallbackMethod = "services_error_fallback" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommonResult services_error(){
        return hystrixClientServices.services_error();
    }

    @GetMapping("/hystrix/client/timeout/{id}")
    @HystrixCommand(fallbackMethod = "services_timeout_fallback" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommonResult services_timeout(@PathVariable("id") Long id){
        return hystrixClientServices.services_timeout(id);
    }

    public CommonResult services_error_fallback(){
        return new CommonResult(200,"服务运行异常！",null);
    }

    public CommonResult services_timeout_fallback(Long id){
        return new CommonResult(200,"服务连接超时！超时时间(ms)：" + id,null);
    }
}
