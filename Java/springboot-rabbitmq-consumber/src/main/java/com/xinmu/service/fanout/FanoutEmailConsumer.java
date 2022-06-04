package com.xinmu.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * author: xinmu
 * date: 2022/5/7
 * time: 23:40
 */

@Service
@RabbitListener(queues = {"email.fanout.queue"})
public class FanoutEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("邮箱fanout---接收到了消息是:"+message);
    }

}
