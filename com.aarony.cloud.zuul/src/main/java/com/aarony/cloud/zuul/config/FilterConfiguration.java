package com.aarony.cloud.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aarony.cloud.zuul.filter.AccessFilter;
import com.aarony.cloud.zuul.filter.ErrorFilter;

@Configuration
public class FilterConfiguration {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    // 注册错误处理的filter类
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
