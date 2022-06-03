package com.xinmu.adapter.phone;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:03
 */


public class Phone {

    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5)
            System.out.println("可以充电");
        else
            System.out.println("电压不匹配");
    }
}
