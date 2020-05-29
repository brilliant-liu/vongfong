package com.icop.vongfeng.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/29
 * @description：
 */
@EnableBinding(Sink.class)
@Slf4j
public class consumerImple {

    @Value("${server.port}")
    String servertPort;

    @StreamListener(Sink.INPUT)
    public void consemer(Message<String> message){
        log.info(servertPort+ "我开始消费了："+message.getPayload());
    }
}
