package com.xinmu.pojo;

/**
 * author: xinmu
 * date: 2022/3/31
 * time: 23:09
 */


public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
