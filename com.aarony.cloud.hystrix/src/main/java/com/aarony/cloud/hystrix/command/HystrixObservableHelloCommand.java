package com.aarony.cloud.hystrix.command;

import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * @author Aarony
 * @Description: 支持多次请求的，这个使用的是命令模式的请求
 * @date 2018/1/25 13:56
 */
public class HystrixObservableHelloCommand extends HystrixObservableCommand<String> {

   @Autowired
   RestTemplate restTemplate;

   protected HystrixObservableHelloCommand(Setter setter) {
      super(setter);
   }

   @Override
   protected Observable<String> construct() {
      return Observable.create(new OnSubscribe<String>() {
         @Override
         public void call(Subscriber<? super String> subscriber) {
            try {
               if (subscriber.isUnsubscribed()) {
                  String result = restTemplate.getForObject("http://hello-server/hello", String.class);
                  subscriber.onNext(result);
                  subscriber.onCompleted();
               }
            } catch (Exception ex) {
               throw ex;
            }
         }
      });
   }
}
