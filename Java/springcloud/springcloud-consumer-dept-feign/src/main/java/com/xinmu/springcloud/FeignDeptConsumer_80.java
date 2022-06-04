package com.xinmu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 22:29
 */

//Ribbon 和 Eureka 整合以后,客户端可以直接调用,不用关系ip地址
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xinmu.springcloud"})
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }

}
