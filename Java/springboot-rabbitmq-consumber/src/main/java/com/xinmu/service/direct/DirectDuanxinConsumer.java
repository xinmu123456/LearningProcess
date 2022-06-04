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
@RabbitListener(queues = {"duanxin.direct.queue"})
public class DirectDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("短信direct---接收到了消息是:"+message);
    }

}
