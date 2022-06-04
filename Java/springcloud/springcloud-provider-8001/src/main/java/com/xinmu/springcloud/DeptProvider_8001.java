package com.xinmu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 20:56
 */

@EnableEurekaClient // 在服务启动后字段注册到eureka
@SpringBootApplication
@EnableDiscoveryClient
public class DeptProvider_8001 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DeptProvider_8001.class,args);
    }

    //增加一个servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
