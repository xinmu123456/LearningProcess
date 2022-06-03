package com.xinmu.myspring.entity;

import com.xinmu.myspring.anno.Component;
import com.xinmu.myspring.anno.Value;
import lombok.Data;

/**
 * author: xinmu
 * date: 2022/5/30
 * time: 19:55
 */

@Component("myOrder")
@Data
public class Order {
    @Value("xx123")
    private String orderId;
    @Value("1000.5")
    private Float price;
}
