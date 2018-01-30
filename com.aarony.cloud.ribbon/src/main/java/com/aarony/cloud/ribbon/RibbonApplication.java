package com.aarony.cloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/19 18:34
 */

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {

   public static void main(String[] args) {
      SpringApplication.run(RibbonApplication.class, args);
   }


}
