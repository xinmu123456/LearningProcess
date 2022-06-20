package com.xinmu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xinmu
 * date 2022/3/23
 * time: 20:49
 */


public class CharacterEncodingFilter implements Filter {

    //初始化:web服务器启动,就已经初始化了,随时等待过滤对象的出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    //chain : 链
    /*
    1.过滤中的所有代码,在过滤特定请求时后都会执行
    2.必须要让过滤器继续通行
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前...");
        chain.doFilter(request,response);//让我们的请求继续走,如果不写这个程序就被拦截停止了
        System.out.println("CharacterEncodingFilter执行后...");

    }

    //销毁:web服务器关闭的时候,过滤器会销毁
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
