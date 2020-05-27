package com.icop.vongfong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liukj
 * @date: 2020/5/26
 * @description：
 */
@RestController
@RefreshScope // 手动发送post请求刷新缓存：curl -X POST "http://localhost:3355/actuator/refresh"
public class ControllerModify {

    @Value("${ribbon.ConnectionTimeout}")
    //@Value("${eureka.client.service-url.defaultZone}")
    private String configInfo;

    @GetMapping("/configclient1/configInfo")
    public String getConfig(){
        return configInfo;
    }
}
