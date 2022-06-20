package com.xinmu.filter;

import com.xinmu.pojo.User;
import com.xinmu.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/3/25
 * time: 18:34
 */


public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //过滤器,从Session中获取用户
        User user = (User)request.getSession().getAttribute(Constants.USER_SESSION);

        if (user==null){//已经被移除或者注销,或者未登录
            response.sendRedirect("/error.jsp");
        }else{
            chain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
