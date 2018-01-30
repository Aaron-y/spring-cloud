package com.aarony.cloud.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/23 11:19
 */
@RestController
public class CustomerController {

   @Autowired
   com.aarony.cloud.hystrix.service.HelloService HelloService;

   @RequestMapping(value = "/hello")
   public String testService() {
      return HelloService.hiService("张三");
   }


}
