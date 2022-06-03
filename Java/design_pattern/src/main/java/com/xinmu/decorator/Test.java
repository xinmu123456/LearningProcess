package com.xinmu.decorator;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 16:08
 */


public class Test {
    public static void main(String[] args) {
        Robot robot = new FirstRobot();
        robot.doSomething();
        RobotDecorator robotDecorator = new RobotDecorator(robot);
        robotDecorator.doMoreThing();
    }
}
