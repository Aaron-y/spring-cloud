package com.aarony.cloud.bus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/31 11:12
 */
@SpringBootApplication
public class BusApplication {

   public static void main(String[] args) {

      new SpringApplicationBuilder(BusApplication.class).web(true).run(args);
   }

}
