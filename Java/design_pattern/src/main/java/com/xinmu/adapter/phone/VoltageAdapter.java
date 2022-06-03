package com.xinmu.adapter.phone;

import com.xinmu.adapter.phone.IVoltage5V;
import com.xinmu.adapter.phone.Voltage220V;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:06
 */


public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        int srcV = output220V();
        int dstV = srcV/44;
        return dstV;
    }
}
