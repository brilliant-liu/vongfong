package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@RestController
@Slf4j
public class OrderController {

    public static final String paymentUrl = "http://localhost:8001/payment/";

    @Resource
    private RestTemplate getRestTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  getRestTemplate.postForObject(paymentUrl+"create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        return  getRestTemplate.getForObject(paymentUrl+"get/"+id,CommonResult.class);
    }

}
