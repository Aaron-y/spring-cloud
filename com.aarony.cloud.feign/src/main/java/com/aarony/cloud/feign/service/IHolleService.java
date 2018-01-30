package com.aarony.cloud.feign.service;

import com.aarony.cloud.feign.config.FullLogConfiguration;
import com.aarony.cloud.feign.fallBack.HelloServicesFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aarony.cloud.core.model.User;


// 这个对应着 com.aarony.cloud.provider 里面的 spring name
//定义log的输出级别
@FeignClient(value = "hello-server", fallback = HelloServicesFallBack.class, configuration = {FullLogConfiguration.class})
public interface IHolleService {

   // 这个对应着里面 的 controller 里面的 hello mapping
   @RequestMapping("/hello")
   String hello();

   @RequestMapping(value = "/hello1", method = RequestMethod.GET)
   String hello(@RequestParam("name") String name);

   @RequestMapping(value = "/hello2", method = RequestMethod.GET)
   String hello(@RequestParam("name") String name, @RequestHeader("age") Integer age);

   @RequestMapping(value = "/hello3", method = RequestMethod.POST)
   String hello(@RequestBody User user);
}
