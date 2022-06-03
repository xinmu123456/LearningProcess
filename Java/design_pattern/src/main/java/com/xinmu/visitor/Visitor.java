package com.xinmu.visitor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:46
 */


public interface Visitor {
    void visitCPU (CPU cpu);

    void visitDisk(HardDisk disk);
}
