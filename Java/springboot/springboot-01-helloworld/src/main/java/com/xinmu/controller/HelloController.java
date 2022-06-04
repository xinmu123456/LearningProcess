package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: xinmu
 * date: 2022/4/14
 * time: 16:46
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
