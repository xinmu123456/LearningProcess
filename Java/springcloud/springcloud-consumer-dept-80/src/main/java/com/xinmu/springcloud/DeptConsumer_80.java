package com.xinmu.springcloud;

import com.xinmu.myrule.XinmuRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 22:29
 */

//Ribbon 和 Eureka 整合以后,客户端可以直接调用,不用关系ip地址
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载自定义的Ribbon类
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = XinmuRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }

}
