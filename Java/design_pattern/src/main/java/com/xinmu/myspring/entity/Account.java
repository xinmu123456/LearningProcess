package com.xinmu.myspring.entity;

import com.xinmu.myspring.anno.Autowired;
import com.xinmu.myspring.anno.Component;
import com.xinmu.myspring.anno.Value;
import lombok.Data;

/**
 * author: xinmu
 * date: 2022/5/30
 * time: 19:44
 */

@Component
@Data
public class Account {
    @Value("1")
    private Integer id;
    @Value("张三")
    private String name;
    @Value("22")
    private Integer age;

    @Autowired
    private Order order;
}
