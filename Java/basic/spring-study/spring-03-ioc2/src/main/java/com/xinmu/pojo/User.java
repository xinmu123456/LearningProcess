package com.xinmu.pojo;

/**
 * author: xinmu
 * date: 2022/4/1
 * time: 10:19
 */


public class User {
    private String name;

    public User(String name){
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name = "+ name);
    }
}
