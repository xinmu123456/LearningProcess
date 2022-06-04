package com.xinmu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 23:22
 */

@SpringBootApplication
@EnableEurekaServer //表示是服务端的启动类,可以接受别人注册进来
public class EureKaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EureKaServer_7003.class,args);
    }
}
