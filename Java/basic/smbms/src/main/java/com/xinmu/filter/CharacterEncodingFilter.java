package com.xinmu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/3/24
 * time: 13:06
 */


public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
