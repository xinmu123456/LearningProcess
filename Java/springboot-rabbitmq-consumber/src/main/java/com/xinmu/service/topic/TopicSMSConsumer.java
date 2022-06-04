package com.xinmu.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * author: xinmu
 * date: 2022/5/7
 * time: 23:40
 */

@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.sms.#"
))
public class TopicSMSConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("SMS topic---接收到了消息是:"+message);
    }

}
