package com.xinmu.springcloud.controller;

import com.xinmu.springcloud.pojo.Dept;
import com.xinmu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 20:49
 */


//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    //获得一些配置的信息,得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryDeptById(id);
        System.err.println("我走的8001");
        if (dept == null ){
            throw new  RuntimeException("Fail");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }

    //注册进来的微服务,获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>"+services);

        //得到一个具体的微服务,通过具体的微服务的id,applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.client;
    }
}
