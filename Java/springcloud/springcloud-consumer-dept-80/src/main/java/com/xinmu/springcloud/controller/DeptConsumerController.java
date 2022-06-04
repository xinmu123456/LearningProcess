package com.xinmu.springcloud.controller;

import com.xinmu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;  //提供多个边界访问远程http访问的方法,简单的restful的服务模板

    //ribbon 这个地址应该是一个变量,通过服务名来访问
    //private static final  String REST_URL_PREFIX="http://localhost:8001";
    private static final  String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return Boolean.TRUE.equals(restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", dept, Boolean.class));
    }


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
