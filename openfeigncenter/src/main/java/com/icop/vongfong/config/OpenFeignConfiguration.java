package com.icop.vongfong.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liukj
 * @date: 2020/5/19
 * @description：
 */
@Configuration
public class OpenFeignConfiguration {

    /**
     * 设置openFeign的日志级别，设置之后，在application.yml中进行开启服务日志的指定
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
