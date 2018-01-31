package com.aarony.cloud.bus.rabbitMq;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/31 11:17
 */
@Component
public class Send {

   @Autowired
   private AmqpTemplate template;

   public void send() {
      String context = "hello" + new Date();
      System.out.println("sender: " + context);
      this.template.convertAndSend(context);
   }

}
