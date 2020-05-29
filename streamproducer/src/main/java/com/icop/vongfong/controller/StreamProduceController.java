package com.icop.vongfong.controller;

import cn.hutool.core.util.IdUtil;
import com.icop.vongfong.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * @author: liukj
 * @date: 2020/5/28
 * @description：
 */
@RestController
@Slf4j
public class StreamProduceController {

    @Resource
    IProduceServices produceServices;

    @GetMapping("/hystrix/services/ok")
    public CommonResult services_ok(){
        String id = IdUtil.fastSimpleUUID();
        Thread thread = Thread.currentThread();
        String result = MessageFormat.format("线程id：{0}，线程名称：{1}，时间：{2}",id,thread.getName(), LocalDateTime.now());
        log.info(result);

        Message<String> message = MessageBuilder.withPayload(result).build();
        String send = produceServices.send();

        return new CommonResult(200,String.valueOf(send),result);
    }
}
