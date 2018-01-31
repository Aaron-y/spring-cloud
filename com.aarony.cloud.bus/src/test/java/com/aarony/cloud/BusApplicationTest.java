package com.aarony.cloud;

import com.aarony.cloud.bus.BusApplication;
import com.aarony.cloud.bus.rabbitMq.Send;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Aarony
 * @Description:
 * @date 2018/1/31 11:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BusApplication.class)
@WebAppConfiguration
public class BusApplicationTest {

   @Autowired
   private Send sender;

   @Test
   public void test() {
      sender.send();
   }
}
