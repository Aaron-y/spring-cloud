package com.aarony.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker//开启熔断
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard//开启Hystrix Dashboard 仪表盘
//@SpringCloudApplication 下面这个注解就是上面三个的合并
//@EnableTurbine//开启bine
public class ServiceHystrixApplication {

   public static void main(String[] args) {
      SpringApplication.run(ServiceHystrixApplication.class, args);
   }

   /**
    * 这个使用的是 ribbon的 负载均衡
    */
   @Bean
   @LoadBalanced
   RestTemplate restTemplate() {
      return new RestTemplate();
   }
}
