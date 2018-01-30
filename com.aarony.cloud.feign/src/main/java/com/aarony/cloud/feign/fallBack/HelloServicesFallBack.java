package com.aarony.cloud.feign.fallBack;

import com.aarony.cloud.core.model.User;
import com.aarony.cloud.feign.service.IHolleService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/29 13:48
 */
@Component
public class HelloServicesFallBack implements IHolleService {

   @Override
   public String hello() {
      return "service is fall";
   }

   @Override
   public String hello(@RequestParam("name") String name) {
      return "service is fall";
   }

   @Override
   public String hello(@RequestParam("name") String name, @RequestHeader("age") Integer age) {
      return "service is fall";
   }

   @Override
   public String hello(@RequestBody User user) {
      return "service is fall";
   }
}
