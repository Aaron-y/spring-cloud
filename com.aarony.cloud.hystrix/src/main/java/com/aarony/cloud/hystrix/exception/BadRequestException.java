package com.aarony.cloud.hystrix.exception;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/25 14:16
 */
public class BadRequestException extends RuntimeException {

   public BadRequestException(String message) {
      super(message);
   }
}
