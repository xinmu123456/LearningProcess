package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:46
 */


public class UpdateVisitor implements Visitor{

    @Override
    public void visitCPU(CPU cpu) {
        cpu.command +=":1+1=2";
    }

    @Override
    public void visitDisk(HardDisk disk) {
        disk.command +="记住：1+1=2";
    }
}
