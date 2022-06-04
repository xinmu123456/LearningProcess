package com.xinmu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * author: xinmu
 * date: 2022/4/28
 * time: 22:52
 */

@SpringBootApplication
@EnableConfigServer //开启服务
public class Config_Server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3344.class,args);
    }
}
