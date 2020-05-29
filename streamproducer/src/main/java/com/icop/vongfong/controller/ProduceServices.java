package com.icop.vongfong.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * @author: liukj
 * @date: 2020/5/28
 * @description：
 */
@EnableBinding(Source.class)
@Slf4j
public class ProduceServices implements IProduceServices{

    //消息发送管道
    @Resource
   private MessageChannel output;

    @Override
    public String send(){
        String id = IdUtil.fastSimpleUUID();

        boolean result = output.send(MessageBuilder.withPayload(id).build());
        /*Thread thread = Thread.currentThread();

        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，时间：{2}",id,thread.getName(), LocalDateTime.now());

        Message<String> message = MessageBuilder.withPayload(result).build();
        boolean send = outputs.send(message);
        log.info(result+"send:"+send);*/
        return String.valueOf(result);
    }
}
