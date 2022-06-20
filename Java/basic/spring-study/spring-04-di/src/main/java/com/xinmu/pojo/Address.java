package com.xinmu.pojo;

/**
 * author: xinmu
 * date: 2022/4/1
 * time: 16:33
 */


public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
