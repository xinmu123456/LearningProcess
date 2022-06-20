package com.xinmu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author xinmu
 * @date 2022/3/20 21:42
 * @description:
 */

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器,告诉你你来的时间,然后把这个时间封装成一个信件,你带下来,则就这道你来了

        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out=resp.getWriter();

        //cookie,是服务器端从用户端获得
        Cookie[] cookies= req.getCookies();

        //判断cookie是否存在
        if (cookies!=null){
            //如果存在怎么办
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("lastLoginTime")) {
                    //获取cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);

                    out.write("您上一次访问本站是:"+date.toLocaleString());
                }
            }

        }else{
            out.write("这是您第一次来到本站");
        }

        //服务器给客户端响应一个cookie

        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");

        //给cookie设置有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
