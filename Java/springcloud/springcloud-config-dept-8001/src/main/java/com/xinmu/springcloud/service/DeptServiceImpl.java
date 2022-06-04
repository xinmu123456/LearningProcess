package com.xinmu.springcloud.service;

import com.xinmu.springcloud.dao.DeptDao;
import com.xinmu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 20:46
 */

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptById(Long id) {
        return deptDao.queryDeptById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
