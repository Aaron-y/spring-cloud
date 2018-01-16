package com.aarony.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

// 拦截器
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 校验业务逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} reqyest to {}", request.getMethod(), request.getRequestURI().toString());
        
        Object acccessToken=request.getParameter("acccessToken");
        if(acccessToken==null){
            log.warn("access token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;//判断该过滤器是否需要被执行
    }

    @Override
    public int filterOrder() {
        return 0;//执行顺序，根据返回值来执行
    }

    @Override
    public String filterType() {
        return "pre";// 过滤的类型，在拦截之前做处理
    }

}
