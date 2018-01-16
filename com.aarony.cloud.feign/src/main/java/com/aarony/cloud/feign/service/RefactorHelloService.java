package com.aarony.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.aarony.cloud.feign.config.FullLogConfiguration;
import com.aarony.cloud.hello.api.service.HelloService;

// 使用配置的方式来实现中间层【com.aarony.cloud.hello-api】
// HelloServiceFallBack 发生错误之后的跳转
@FeignClient(name = "hello-server", configuration = {FullLogConfiguration.class})
public interface RefactorHelloService extends HelloService {

}
