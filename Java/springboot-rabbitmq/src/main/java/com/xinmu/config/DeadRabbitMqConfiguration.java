package com.xinmu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: xinmu
 * date: 2022/5/8
 * time: 18:16
 */

@Configuration
public class DeadRabbitMqConfiguration {

    //1.声明注册direct模式的交换机
    @Bean
    public DirectExchange deadDirect(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }

    //2.设置队列
    @Bean
    public Queue deadqueue(){
        return new Queue("dead.direct.queue",true);
    }

    //3.绑定队列和交换机
    @Bean
    public Binding deadbinds(){
        return BindingBuilder.bind(deadqueue()).to(deadDirect()).with("dead");
    }


}
