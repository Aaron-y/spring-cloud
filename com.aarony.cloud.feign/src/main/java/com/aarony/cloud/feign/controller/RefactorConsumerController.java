package com.aarony.cloud.feign.controller;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.feign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/29 11:40
 */
@RestController
@RequestMapping("refactor")
public class RefactorConsumerController {

   // 使用中间层来配置
   @Autowired
   RefactorHelloService refactorHelloService;

   @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
   public String helloConsumer() {
      return refactorHelloService.hello("张珊");
   }

   @RequestMapping(value = "feign-consumer2", method = RequestMethod.GET)
   public String helloConsumer2() {
      StringBuilder sb = new StringBuilder();
      sb.append(refactorHelloService.hello("test")).append("\n");
      sb.append(refactorHelloService.hello("DIDI")).append("\n");
      sb.append(refactorHelloService.hello("DODO", 12).toString()).append("\n");
      sb.append(refactorHelloService.hello(new User("OIOI", 15))).append("\n");
      return sb.toString();
   }

   @RequestMapping(value = "feign-consumer3", method = RequestMethod.GET)
   public String helloConsumer3() {
      StringBuilder sb = new StringBuilder();
      sb.append(refactorHelloService.hello("DIDI111111111")).append("\n");
      sb.append(refactorHelloService.hello(new User("OIOI1111111111", 15))).append("\n");
      return sb.toString();
   }
}
