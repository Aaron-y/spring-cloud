package com.aarony.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//开启feign的支持，以及Eureka 的客户端
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

   public static void main(String[] args) {
      SpringApplication.run(ConsumerApplication.class, args);
   }


   /**
    * @author Aarony
    * @Description: 这个@LoadBalanced 是用来实现 负载均衡
    * @date 2018/1/18 14:07
    */
   @Bean
   @LoadBalanced
   RestTemplate restTemplate() {
      return new RestTemplate();
   }

}
