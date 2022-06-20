package com.xinmu.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xinmu.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 15:15
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test(@RequestParam("username") String name, Model model){
        //1.接收前端的参数
        System.out.println("接收到前端的参数为: "+name);
        //2.将返回的结果传递给前
        model.addAttribute("msg",name);

        //3.视图跳转
        return "test";
    }

    //前端接收的是一个对象:id,name,age
    /*
    1.接收前端用户传递的参数,判断参数的名字,假设名字直接在方法上,则可以直接使用
    2.假设传递的是一个对象user,匹配user对象中的字段名;如果名字一致则ok,否则匹配不到
     */
    @GetMapping("/t2")
    public String test(User user){
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap map){

        map.addAttribute("");

        return "test";

    }

}
