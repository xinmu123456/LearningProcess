package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 11:12
 */

//房东
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
