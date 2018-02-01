package com.aarony.cloud.tream.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Aarony
 * @Description:
 * @date 2018/2/1 10:25
 */
public interface Source {

   String OUTPUT = "output";

   @Output(Source.OUTPUT)
   MessageChannel output();
}
