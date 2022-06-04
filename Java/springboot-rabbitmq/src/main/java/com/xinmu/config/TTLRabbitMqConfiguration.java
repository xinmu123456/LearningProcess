package com.xinmu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * author: xinmu
 * date: 2022/5/8
 * time: 16:19
 */

@Configuration
public class TTLRabbitMqConfiguration {

    //注册交换机
    @Bean
    public DirectExchange ttldirectExchange(){
        return new DirectExchange("ttl_direct_exchange",true,false);
    }

    //声明队列
    @Bean
    public Queue directttlQueue(){

        HashMap<String, Object> args = new HashMap<>();
        //过期时间
        args.put("x-message-ttl",5000);
        args.put("x-dead-letter-exchange","dead_direct_exchange");
        args.put("x-dead-letter-routing-key","dead");//若是fanout则不用配置

        return new Queue("ttl.direct.queue",true,false,false,args);

    }


    @Bean
    public Binding directttlBingding(){
        return BindingBuilder.bind(directttlQueue()).to(ttldirectExchange()).with("ttl");
    }

}
