package com.xinmu.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xinmu
 * date: 2022/4/14
 * time: 15:40
 */


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        //调用业务,接收前端的参数
        return "Hello,World";
    }

}
