package com.icop.vongfong.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * @author: liukj
 * @date: 2020/5/23
 * @description：
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String id = exchange.getRequest().getId();
        URI uri = exchange.getRequest().getURI();
        if(uri.getPath().contains("10")){
            log.info(MessageFormat.format("自定义网关全局过滤器-拒绝通过: 访问地址：{0}，访问时间：{1}",uri.getPath(),LocalDateTime.now()));
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }else {
            log.info(MessageFormat.format("自定义网关全局过滤器-允许通过: 访问地址：{0}，访问时间：{1}",uri.getPath(),LocalDateTime.now()));
        }

        return chain.filter(exchange);
    }

    /**
     * 指定加载过滤器的顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
