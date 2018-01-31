package com.aarony.cloud.bus.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/31 11:24
 */
@Configuration
public class RabbitMqConfig {

   /**
    * @author Aarony
    * @Description: 注册队列名称
    * @params
    * @date 2018/1/31 11:26
    */
   @Bean
   public Queue helloQueue() {
      return new Queue("hello");
   }
}
