package com.xinmu.springcloud.controller;

import com.xinmu.springcloud.pojo.Dept;
import com.xinmu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 21:21
 */

@RestController
public class DeptConsumerController {

    //理解消费者,不应该有service层
    //RestTemplate 供我们直接调用就可以了 注册到spring中
    //url,实体:Map,Class<T> responseType

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClientService.queryAll();
    }

}
