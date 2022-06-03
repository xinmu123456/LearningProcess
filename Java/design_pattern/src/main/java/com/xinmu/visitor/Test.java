package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:54
 */


public class Test {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.calc();
        UpdateVisitor updateVisitor = new UpdateVisitor();
        robot.accept(updateVisitor);
        robot.calc();
    }
}
