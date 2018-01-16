package com.aarony.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
    public String helloConsumer() {
        //hello-server 是provider的spring.application.name=hello-server
        // hello  为 方法 上面的mapping
        return restTemplate.getForEntity("http://hello-server/hello", String.class).getBody();
    }
}
