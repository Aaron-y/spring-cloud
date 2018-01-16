package com.aarony.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy//网关
@SpringCloudApplication //下面这个注解就是下面的合并
//@EnableTurbine//开启bine
//@EnableHystrix
//@EnableDiscoveryClient
//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
