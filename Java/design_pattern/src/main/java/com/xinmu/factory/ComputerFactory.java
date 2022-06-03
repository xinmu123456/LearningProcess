package com.xinmu.factory;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:13
 */


public class ComputerFactory {
    public Computer createComputer(String name){
        if ("a".equals(name))
            return new ComputerA();
        if ("b".equals(name))
            return new ComputerB();

        return null;
    }
}
