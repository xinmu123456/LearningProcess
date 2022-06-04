package com.xinmu.springcloud.service;

import com.xinmu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

    @PostMapping("/dept/list")
    boolean addDept(Dept dept);

}
