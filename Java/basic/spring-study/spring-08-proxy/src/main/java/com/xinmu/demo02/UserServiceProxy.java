package com.xinmu.demo02;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 11:34
 */


public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("[debug]使用了"+msg+"的方法");
    }
}
