package com.aarony.cloud.bus.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/31 11:21
 */
@Component
@RabbitListener(queues = "hello")
public class Receive {

   /**
    * 接收消息
    */
   @RabbitHandler
   public void process(String hello) {
      System.out.println("receive :" + hello);
   }
}
