package com.aarony.cloud.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * 
    * 此类描述的是：  错误拦截类
    * @author: Aarony  
    * @version: Nov 7, 2017 2:07:13 PM
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
