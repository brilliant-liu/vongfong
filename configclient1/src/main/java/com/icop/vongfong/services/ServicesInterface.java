package com.icop.vongfong.services;

import com.icop.vongfong.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: liukj
 * @date: 2020/5/26
 * @description：
 */
@FeignClient(value = "hystrixcenter")
@Component
public interface ServicesInterface {

    @GetMapping("/hystrix/services/ok")
    public CommonResult services_ok();

    @GetMapping("/hystrix/services/error")
    public CommonResult services_error();

    @GetMapping("/hystrix/services/timeout/{id}")
    public CommonResult services_timeout(@PathVariable("id") Long id);
}
