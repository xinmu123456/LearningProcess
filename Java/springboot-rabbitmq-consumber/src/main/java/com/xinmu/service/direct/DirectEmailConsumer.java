package com.xinmu.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * author: xinmu
 * date: 2022/5/7
 * time: 23:40
 */

@Service
@RabbitListener(queues = {"email.direct.queue"})
public class DirectEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("邮箱direct---接收到了消息是:"+message);
    }

}
