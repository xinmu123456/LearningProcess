package com.xinmu.factory_method;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:39
 */


public class XiaomiPhoneFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }
}
