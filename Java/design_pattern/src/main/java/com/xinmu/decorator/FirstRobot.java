package com.xinmu.decorator;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 16:05
 */


public class FirstRobot implements Robot{
    @Override
    public void doSomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}
