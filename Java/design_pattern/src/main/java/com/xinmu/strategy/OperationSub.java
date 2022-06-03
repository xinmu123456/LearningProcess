package com.xinmu.strategy;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 10:46
 */


public class OperationSub implements Operation{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
