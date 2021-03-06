package com.aarony.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//刷新配置用的
@EnableDiscoveryClient
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    // 从远程获取的数据
    @Value("${from}")
    String from;

    @RequestMapping("/")
    String hello() {
        return "Hello " + from + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
