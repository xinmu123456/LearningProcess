package com.xinmu.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 16:15
 */


public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}