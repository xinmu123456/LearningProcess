package com.xinmu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/3/24
 * time: 9:18
 */


public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if ( request.getSession().getAttribute("USER_SESSION")==null){
            response.sendRedirect("/error.jsp");
        }


        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
