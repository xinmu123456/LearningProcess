package com.xinmu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * author: xinmu
 * date: 2022/3/23
 * time: 21:30
 */

//统计网站的在线人数:统计session
public class OnlineCountListener implements HttpSessionListener {

    //创建session的监听
    //一旦创建一个session就会触发一次这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount =(Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(1);
        }else{
            int count = onlineCount.intValue();

            onlineCount = new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }

    //销毁session监听
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount =(Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(0);
        }else{
            int count = onlineCount.intValue();

            onlineCount = new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }

    /*
    Session销毁
    1.手动销毁 getSession().invalidate();
    2.自动销毁
     */
}
