package com.xinmu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: xinmu
 * date: 2022/4/16
 * time: 11:18
 */

//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id;
    private String name;
}
