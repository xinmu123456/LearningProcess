package com.xinmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 14:57
 */

@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")
    public String test(Model model){

        model.addAttribute("msg","modelTest1");
        return "redirect:/index.jsp";
    }

}
