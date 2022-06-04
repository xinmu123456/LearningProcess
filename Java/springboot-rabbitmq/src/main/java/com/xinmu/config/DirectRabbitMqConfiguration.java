package com.xinmu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: xinmu
 * date: 2022/5/8
 * time: 13:19
 */

@Configuration
public class DirectRabbitMqConfiguration {

    //1.声明Direct模式的交换机
    @Bean
    public DirectExchange DirectExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }

    //2.声明队列
    @Bean
    public Queue directsmsQueue(){
        return new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue directduanxinQueue(){
        return new Queue("duanxin.direct.queue",true);
    }
    @Bean
    public Queue directemailQueue(){
        return new Queue("email.direct.queue",true);
    }

    //3.完成绑定关系 队列和交换机完成绑定
    @Bean
    public Binding directsmsBingding(){
        return BindingBuilder.bind(directsmsQueue()).to(DirectExchange()).with("sms");
    }

    @Bean
    public Binding directduanxinBingding(){
        return BindingBuilder.bind(directduanxinQueue()).to(DirectExchange()).with("email");
    }

    @Bean
    public Binding directemailBingding(){
        return BindingBuilder.bind(directemailQueue()).to(DirectExchange()).with("duanxin");
    }


}
