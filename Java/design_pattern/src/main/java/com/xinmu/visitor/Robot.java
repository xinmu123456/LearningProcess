package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:44
 */


public class Robot {
    private HardDisk disk;
    private CPU cpu;

    public Robot() {
        this.disk = new HardDisk("记住1+1=1");
        this.cpu = new CPU("1+1=1");
    }

    public void accept(Visitor visitor){
        cpu.accept(visitor);
        disk.accept(visitor);
    }

    public void calc(){
        cpu.run();
        disk.run();
    }
}
