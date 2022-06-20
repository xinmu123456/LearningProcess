package com.xinmu.untils;


import org.junit.Test;

import java.util.UUID;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 21:44
 */


public class IDUntils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDUntils.getId());
        System.out.println(IDUntils.getId());
        System.out.println(IDUntils.getId());
    }

}
