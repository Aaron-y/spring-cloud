package com.aarony.cloud.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aarony.cloud.core.model.User;


@RestController
public class HelloController {
    private final static Logger Logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        Logger.info("host:" + instance.getHost() + "; port:" + instance.getPort());
        return "hello world!";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Logger.info("host:" + instance.getHost() + "; port:" + instance.getPort());
        return "hello " + name;        
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestParam String name, @RequestHeader Integer age) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Logger.info("host:" + instance.getHost() + "; port:" + instance.getPort());
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Logger.info("host:" + instance.getHost() + "; port:" + instance.getPort());
        return "hello " + user.getName() + "," + user.getAge();
    }
}
