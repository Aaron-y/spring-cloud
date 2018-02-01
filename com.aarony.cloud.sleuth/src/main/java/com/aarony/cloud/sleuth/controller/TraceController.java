package com.aarony.cloud.sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aarony
 * @Description:
 * @date 2018/2/1 10:46
 */
@RestController
public class TraceController {

   @Autowired
   private RestTemplate restTemplate;

   @RequestMapping("/hello")
   public String syaHello() {
      return restTemplate.getForObject("http://hello-server/hello", String.class);
   }
}
