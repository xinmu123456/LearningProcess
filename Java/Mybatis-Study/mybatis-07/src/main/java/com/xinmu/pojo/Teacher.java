package com.xinmu.pojo;

import lombok.Data;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 17:04
 */


@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师有多个学生的集合
    private List<Student> students;
}
