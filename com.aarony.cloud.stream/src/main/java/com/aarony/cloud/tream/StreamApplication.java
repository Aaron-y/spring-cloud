package com.aarony.cloud.tream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Aarony
 * @Description:
 * @date 2018/2/1 9:46
 */

@SpringBootApplication
public class StreamApplication {

   public static void main(String[] args) {

      new SpringApplicationBuilder(StreamApplication.class).web(true).run(args);
   }
}
