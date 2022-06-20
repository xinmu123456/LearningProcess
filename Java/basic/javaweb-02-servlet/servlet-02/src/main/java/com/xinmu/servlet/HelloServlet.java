package com.xinmu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xinmu
 * @date 2022/3/20 13:28
 * @description:
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.getInitParameter() 初始化参数
        //this.getServletConfig()  servlet配置
        //this.getServletContext() servlet上下文
        ServletContext context = this.getServletContext();

        String username="新木";//数据
        context.setAttribute("username",username);//将一个数据保存在了servletcontext中,名字为username,值为username

        System.out.println("hello");
    }
}
