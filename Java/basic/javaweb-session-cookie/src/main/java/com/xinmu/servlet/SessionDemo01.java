package com.xinmu.servlet;

import com.xinmu.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author xinmu
 * @date 2022/3/22 19:20
 * @description:
 */
public class SessionDemo01 extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码的问题
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session=req.getSession();

        //给session中存东西
        session.setAttribute("name",new Person("新木",1) );

        //获取session中的id
        String sessionId = session.getId();

        //判断session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session 创建成功,ID:" +sessionId);
        }else{
            resp.getWriter().write("session 已经在服务器中存在了 ID:"+sessionId);
        }

//        //Session创建的时候做了什么事情:  #猜想
//        Cookie cookie = new Cookie("JSESSIONID",sessionId);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
