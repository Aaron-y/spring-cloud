package com.aarony.cloud.tream.amqp;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author Aarony
 * @Description:
 * @date 2018/2/1 9:52
 */
@EnableBinding({Sink.class})
public class SkinReceive {

   @StreamListener(Sink.INPUT)
   public void receive(Object payload) {
      System.out.println("received：" + payload);
   }
}
