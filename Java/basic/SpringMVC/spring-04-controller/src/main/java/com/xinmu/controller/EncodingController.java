package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 15:58
 */

@Controller

public class EncodingController {

    //过滤器解决乱码
    @PostMapping ("/e/t1")
    public String test(String name, Model model){

        System.out.println(name);
        model.addAttribute("msg",name);

        return "test";

    }

}
