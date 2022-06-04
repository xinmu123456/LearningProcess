package com.xinmu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 21:30
 */

@Configuration
public class ConfigBean { //@Configuration -- spring applicationContext.xml

    //配置负载均衡实现restTemplate
    //IRule
    //RandomRule 随机
    //RoundRobinRule 轮询
    //AvailabilityFilteringRule : 会过滤掉跳闸,访问故障的服务,对剩下的进行轮询
    //RetryRule 会先按照轮询获取服务,然后服务获取失败,则会在指定的时间内进行重试
    @Bean
    @LoadBalanced //ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
