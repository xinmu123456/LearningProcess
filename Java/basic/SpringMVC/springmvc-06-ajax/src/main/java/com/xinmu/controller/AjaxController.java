package com.xinmu.controller;

import com.xinmu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/9
 * time: 10:54
 */

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String  test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if ("xinmu".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> userList = new ArrayList<>();

        //添加数据
        userList.add(new User("新木",1,"男"));
        userList.add(new User("xinmu",1,"男"));
        userList.add(new User("user",1,"女"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";
        if (name!=null){
            if ("admin".equals(name)){
                msg="ok";
            }else {
                msg = "用户名有误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg="ok";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }

}
