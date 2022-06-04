package com.xinmu.springcloud.dao;

import com.xinmu.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryDeptById(Long id);

    List<Dept> queryAll();
}
