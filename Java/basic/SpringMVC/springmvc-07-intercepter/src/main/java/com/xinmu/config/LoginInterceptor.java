package com.xinmu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * author: xinmu
 * date: 2022/4/9
 * time: 16:43
 */


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行:判断什么情况下登录了
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        //说明我提交登录
        if(request.getRequestURI().contains("login")){
            return true;
        }

        if (session.getAttribute("userLoginInfo") != null){
            return true;
        }

        //判断什么情况下没登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
