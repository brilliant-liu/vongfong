package com.icop.vongfong.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ipresolver.RemoteAddressResolver;
import org.springframework.cloud.gateway.support.ipresolver.XForwardedRemoteAddressResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liukj
 * @date: 2020/5/23
 * @description：
 */
//@Configuration
public class RoutesConfiguration {

    //@Bean
    public RouteLocator routes (RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("payment_routh_bean",
                r-> r.path("/payment/get/**")
                        .uri("http://localhost:8001")).build();

        return routes.build();
    }
}
