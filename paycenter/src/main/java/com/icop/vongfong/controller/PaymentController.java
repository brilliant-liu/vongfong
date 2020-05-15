package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.entities.Payment;
import com.icop.vongfong.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServices paymentServices;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("payment:"+payment.getSerial());
        int i = paymentServices.create(payment);
        if(1==i){
            return new CommonResult<>(200,"成功",i);
        }
        return new CommonResult<>(444,"失败",i);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment= paymentServices.getPaymentById(id);
        if(null!=payment){
            return new CommonResult<Payment>(200,"成功",payment);
        }
        return new CommonResult<Payment>(444,"查询失败",null);
    }
}
