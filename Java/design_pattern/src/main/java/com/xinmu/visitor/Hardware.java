package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:45
 */


public abstract class Hardware {
    String command;

    public Hardware(String command) {
        this.command = command;
    }

    public void run(){
        System.out.println(command);
    }

    public abstract void accept(Visitor visitor);
}
