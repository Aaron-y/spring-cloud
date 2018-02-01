package com.aarony.cloud.tream.amqp;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Aarony
 * @Description:
 * @date 2018/2/1 9:53
 */
public interface Sink {

   String INPUT = "input";

   @Input(Sink.INPUT)
   SubscribableChannel input();
}
