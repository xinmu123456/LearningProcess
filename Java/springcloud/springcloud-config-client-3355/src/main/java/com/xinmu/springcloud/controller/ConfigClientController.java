package com.xinmu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xinmu
 * date: 2022/4/28
 * time: 23:28
 */

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("server.port")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName:"+applicationName+
                "eurekaServer:"+eurekaServer+
                "port:"+port;

    }

}
