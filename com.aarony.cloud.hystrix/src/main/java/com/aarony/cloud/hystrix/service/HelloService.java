package com.aarony.cloud.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // http://hello-server/hello 是服务提供者提供出来的URL
        return restTemplate.getForObject("http://hello-server/hello", String.class);
    }

    /**
     * 这里就是熔断的机制
     * 
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hello," + name + ",sorry service error!";
    }
}
