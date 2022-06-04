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
@RabbitListener(queues = {"duanxin.fanout.queue"})
public class FanoutDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("短信fanout---接收到了消息是:"+message);
    }

}
