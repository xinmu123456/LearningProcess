package com.xinmu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author: xinmu
 * date: 2022/4/5
 * time: 22:21
 */


//只要实现了controller接口的类,说明这就是一个控制器

public class ControllerTest1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","ControllerTest1");
        mv.setViewName("test");

        return mv;
    }
}
