package com.xinmu.decorator;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 16:06
 */


public class RobotDecorator implements Robot{
    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMoreThing(){
        robot.doSomething();
        System.out.println("跳舞");
    }
}
