package com.xinmu.strategy;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 10:47
 */


public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperation(new OperationAdd());
        System.out.println(calculator.doOperation(2, 1));
        calculator.setOperation(new OperationSub());
        System.out.println(calculator.doOperation(2, 1));
    }
}
