package com.xinmu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: xinmu
 * date: 2022/4/28
 * time: 13:30
 */

@Configuration
public class XinmuRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); // 默认是轮询,现在我们自定义为我们自己的
    }


}
