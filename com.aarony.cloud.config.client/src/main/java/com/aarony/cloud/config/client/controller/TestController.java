package com.aarony.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/30 17:59
 */
@RestController
public class TestController {

   /**
    * 环境变量
    */
   @Autowired
   private Environment env;

   @RequestMapping("/form")
   public String form() {
      return env.getProperty("from");
   }

   @RequestMapping("/test")
   public String testOther() {
      Object object = env.getProperty("test");
      if (object == null) {
         return "this is my test";
      }
      return object.toString();
   }
}
