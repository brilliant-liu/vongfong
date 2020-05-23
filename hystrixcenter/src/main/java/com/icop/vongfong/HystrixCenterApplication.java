package com.icop.vongfong;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author: liukj
 * @date: 2020/5/19
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //熔断器的注解
@EnableHystrix
public class HystrixCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixCenterApplication.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容器本身无关，springCloud升级后的坑，
     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     * 因此需要在自己的项目配置下面的servlet就ok了。
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
