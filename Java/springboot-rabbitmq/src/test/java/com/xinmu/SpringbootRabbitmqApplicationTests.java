package com.xinmu;

import com.xinmu.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }

    @Test
    void  directTest(){
        orderService.makeOrderDirect("1","1",12);
    }

    @Test
    void topicTest(){
        orderService.makeOrderTopic("1","1",12);
    }

    @Test
    void ttlTest(){
        orderService.makeOrderTTl("1","1",12);
    }

}
