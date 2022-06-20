package com.xinmu.dao;

import com.xinmu.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生信息,一级对应的老师的信息
    public List<Student> getStudent();

    public List<Student> getStudent2();
}
