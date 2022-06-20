package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: xinmu
 * date: 2022/4/5
 * time: 21:05
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello springmvc annotation");

        return "hello";//会被视图解析器处理
    }

}
