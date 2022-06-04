package com.xinmu.springcloud.service;

import com.xinmu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryDeptById(Long id);

    List<Dept> queryAll();

}
