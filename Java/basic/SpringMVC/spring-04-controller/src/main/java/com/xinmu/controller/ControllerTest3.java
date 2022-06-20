package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 9:47
 */

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String test1(Model model) {
        model.addAttribute("msg","Controller3");
        return "test";
    }

}
