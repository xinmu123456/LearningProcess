package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 10:01
 */

@Controller
public class RestFulController {

    // 原来的风格 http://localhost:8080/spring_04_controller_war_exploded/add?a=1&b=2
    // RestFul风格 http://localhost:8080/spring_04_controller_war_exploded/add/1/2

    //@RequestMapping("/add/{a}/{b}")
    @RequestMapping(value="/add/{a}/{b}",method=RequestMethod.GET)
    public String test1(@PathVariable int a, @PathVariable int b , Model model){

        int res=a+b;

        model.addAttribute("msg","结果1为"+res);

        return "test";

    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b , Model model){

        int res=a+b;

        model.addAttribute("msg","结果2为"+res);

        return "test";

    }


}
