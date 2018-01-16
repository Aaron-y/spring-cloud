/*package com.aarony.cloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.hello.api.service.HelloService;

// 错误的时候退回的
@Component
public class HelloServiceFallBack implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestParam("name") String name, @RequestHeader("age") Integer age) {
        return new User("error", 18);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }

}
*/