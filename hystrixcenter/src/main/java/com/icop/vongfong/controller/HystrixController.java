package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/19
 * @description：
 */
@RestController
@Slf4j
public class HystrixController {

    @Resource
    PaymentServices paymentServices ;

    @Value("${server.port}")
    private String port ;

    @GetMapping("hystrix/payment/ok")
    public CommonResult payment_ok(){
        CommonResult commonResult = paymentServices.payment_ok();
        return commonResult;
    }

    @GetMapping("/hystrix/payment/error")
    public CommonResult payment_error(){
        CommonResult commonResult = paymentServices.payment_error();
        return commonResult;
    }
}
