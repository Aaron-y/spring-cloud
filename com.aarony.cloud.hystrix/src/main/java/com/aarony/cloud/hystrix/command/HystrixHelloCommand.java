package com.aarony.cloud.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aarony
 * @Description: 使用HystrixCommand 注册的只能发射一次消息
 * @date 2018/1/25 11:54
 */
public class HystrixHelloCommand extends HystrixCommand<String> {

   @Autowired
   RestTemplate restTemplate;

   private Integer id;

   private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

   public HystrixHelloCommand(Setter setter, Integer id) {
      super(setter);
      this.id = id;
   }

   @Override
   protected String run() throws Exception {
      return restTemplate.getForObject("http://hello-server/hello", String.class);
   }

   public static void flushCache(Integer id) {
      HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(id.toString());
   }

}
