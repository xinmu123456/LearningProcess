package com.xinmu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * author: xinmu
 * date: 2022/4/28
 * time: 21:12
 */

@SpringBootApplication
@EnableZuulProxy // 启动代理
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class,args);
    }
}
