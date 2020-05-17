package com.icop.vongfong.controller;

import com.icop.vongfong.entities.CommonResult;
import com.icop.vongfong.entities.Payment;
import com.icop.vongfong.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("payment:"+payment.getSerial());
        int i = paymentServices.create(payment);
        if(1==i){
            return new CommonResult<>(200,"成功,端口号："+serverPort,i);
        }
        return new CommonResult<>(444,"失败,端口号："+serverPort,i);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment= paymentServices.getPaymentById(id);
        if(null!=payment){
            return new CommonResult<Payment>(200,"成功,端口号："+serverPort,payment);
        }
        return new CommonResult<Payment>(444,"查询失败,端口号："+serverPort,null);
    }

    @GetMapping(value = "/payment/discovery")
    public CommonResult discovery(){
        Map<String, List<String>> result = new HashMap(6);
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("当前注册的服务："+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            List<String> list = new ArrayList();
            for (ServiceInstance instance : instances) {
                log.info("主机：{0},端口：{1},访问地址：{2}",instance.getHost(),instance.getPort(),instance.getUri());
                list.add(MessageFormat.format("主机：{0},端口：{1},访问地址：{2}",instance.getHost(),instance.getPort(),instance.getUri()));
            }
            result.put(service,list);
        }
        return new CommonResult<Map>(444,"查询微服务信息："+serverPort,result);
    }
}
