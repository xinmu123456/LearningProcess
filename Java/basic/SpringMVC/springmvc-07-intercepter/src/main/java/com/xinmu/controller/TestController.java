package com.xinmu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * author: xinmu
 * date: 2022/4/9
 * time: 15:48
 */

@RestController
public class TestController {

    @GetMapping("/t1")
    public String test() {
        System.out.println("执行了"+this.getClass().getName()+"类的test方法");
        return "OK";
    }
}
