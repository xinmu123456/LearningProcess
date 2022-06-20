package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: xinmu
 * date: 2022/4/5
 * time: 22:32
 */

@Controller //代表这个类会被spring托管,被这个注解的类中的所有方法,如果返回值是String ,并且具有具体的页面可以跳转,那么就会被视图解析器解析
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model){

        model.addAttribute("msg", "ControllerTest2");

        return "test";

    }

    @RequestMapping("/t3")
    public String test3(Model model){

        model.addAttribute("msg", "ControllerTest3");

        return "test";

    }

}
