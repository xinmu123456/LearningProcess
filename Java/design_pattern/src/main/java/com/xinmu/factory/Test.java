package com.xinmu.factory;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:15
 */


public class Test {
    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        Computer a = factory.createComputer("a");
        Computer b = factory.createComputer("b");
    }
}
