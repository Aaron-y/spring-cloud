package com.aarony.cloud.provider.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.hello.api.service.HelloService;

@RestController
@RequestMapping("/refactor")//这个注解不会随 接口一起继承过来，而方法上面的会直接继承过来
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public User hello(@RequestParam("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "hello " + user.getName() + " " + user.getAge();
    }

}
