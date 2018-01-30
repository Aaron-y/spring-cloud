package com.aarony.cloud.hystrix.service;

import com.aarony.cloud.hystrix.command.HystrixHelloCommand;
import com.aarony.cloud.hystrix.command.HystrixObservableHelloCommand;
import com.aarony.cloud.hystrix.exception.BadRequestException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

   @Autowired
   RestTemplate restTemplate;

   @Autowired(required = false)
   HystrixHelloCommand hystrixHelloCommand;

   @Autowired(required = false)
   HystrixObservableHelloCommand hystrixObservableHelloCommand;

   /**
    * 添加熔断器，同步执行
    */
   @HystrixCommand(fallbackMethod = "hiError")
   public String hiService(String name) {
      // http://hello-server/hello 是服务提供者提供出来的URL
      return restTemplate.getForObject("http://hello-server/hello", String.class);
   }

   /**
    * @author Aarony
    * @Description: 使用异步的方式执行
    * @params * @param null
    * @date 2018/1/25 11:37
    */
   @HystrixCommand(fallbackMethod = "hiError")
   public Future<String> hiServiceAsync(String name) {
      return new AsyncResult<String>() {
         @Override
         public String invoke() {
            return restTemplate.getForObject("http://hello-server/hello", String.class);
         }
      };
   }

   @HystrixCommand(fallbackMethod = "hiError", ignoreExceptions = {BadRequestException.class})
   public String hiServiceByCommand(String name) {
      return hystrixHelloCommand.execute();
   }

   /**
    * 这里就是熔断的机制
    */
   public String hiError(String name) {
      return "hello," + name + ",sorry service error!";
   }

}
