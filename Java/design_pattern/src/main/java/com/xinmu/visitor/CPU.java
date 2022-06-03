package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:47
 */


public class CPU extends Hardware{

    public CPU(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }
}
