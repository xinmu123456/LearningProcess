package com.xinmu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/3/23
 * time: 22:47
 */


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        String username = req.getParameter("username");
        if (username.equals("admin")){//登录成功
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect("/sys/success.jsp");
        }else {//失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
