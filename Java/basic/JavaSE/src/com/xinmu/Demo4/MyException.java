package com.xinmu.Demo4;

/**
 * @author xinmu
 * @date 2022/1/20 13:24
 * @description:
 */
public class MyException extends Exception{
    private int detail;


    public MyException(int a) {
        this.detail = a;
    }

    //异常的打印信息
    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
