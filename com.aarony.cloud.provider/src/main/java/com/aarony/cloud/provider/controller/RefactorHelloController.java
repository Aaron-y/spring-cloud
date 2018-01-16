package com.aarony.cloud.provider.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.hello.api.service.HelloService;

@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "hello " + user.getName() + " " + user.getAge();
    }

}
