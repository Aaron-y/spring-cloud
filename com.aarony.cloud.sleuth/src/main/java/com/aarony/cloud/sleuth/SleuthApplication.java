package com.aarony.cloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务跟踪
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthApplication {

   public static void main(String[] args) {
      SpringApplication.run(SleuthApplication.class, args);
   }

   /**
    * 负载均衡
    */
   @Bean
   @LoadBalanced
   public RestTemplate template() {
      return new RestTemplate();
   }
}
