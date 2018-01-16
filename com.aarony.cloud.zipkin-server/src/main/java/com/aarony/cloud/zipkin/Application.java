package com.aarony.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import zipkin.server.EnableZipkinServer;

//@EnableZipkinServer//开启Zipkin 的服务端
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
