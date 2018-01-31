package com.aarony.cloud.turbion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine//开启bine
public class ServiceTurbionApplication {

   public static void main(String[] args) {

      new SpringApplicationBuilder(ServiceTurbionApplication.class).web(true).run(args);
   }
}
