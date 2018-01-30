package com.aarony.cloud.feign.controller;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.feign.service.IHolleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

   @Autowired
   IHolleService helloservice;

   @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
   public String helloConsumer() {
      return helloservice.hello();
   }

   @RequestMapping(value = "feign-consumer2", method = RequestMethod.GET)
   public String helloConsumer2() {
      StringBuilder sb = new StringBuilder();
      sb.append(helloservice.hello()).append("\n");
      sb.append(helloservice.hello("DIDI")).append("\n");
      sb.append(helloservice.hello("DODO", 12)).append("\n");
      sb.append(helloservice.hello(new User("OIOI", 15))).append("\n");
      return sb.toString();
   }

   @RequestMapping(value = "feign-consumer3", method = RequestMethod.GET)
   public String helloConsumer3() {
      StringBuilder sb = new StringBuilder();
      sb.append(helloservice.hello("DIDI111111111")).append("\n");
      sb.append(helloservice.hello("DODO11111111", 12)).append("\n");
      sb.append(helloservice.hello(new User("OIOI1111111111", 15))).append("\n");
      return sb.toString();
   }
}
