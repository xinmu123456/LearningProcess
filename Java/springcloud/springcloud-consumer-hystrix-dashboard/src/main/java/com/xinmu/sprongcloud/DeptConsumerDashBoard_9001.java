package com.xinmu.sprongcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * author: xinmu
 * date: 2022/4/28
 * time: 20:04
 */

@SpringBootApplication
@EnableHystrixDashboard //开启监控页面
public class DeptConsumerDashBoard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoard_9001.class,args);
    }
}
