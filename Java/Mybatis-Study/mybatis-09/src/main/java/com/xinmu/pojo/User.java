package com.xinmu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/3/31
 * time: 11:07
 */

@Data
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
