 package com.yatop.lambda;

 import com.yatop.lambda.framework.listener.frameworkApplicationListener;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
 import org.springframework.boot.builder.SpringApplicationBuilder;
 import org.springframework.boot.context.event.ApplicationPreparedEvent;
 import org.springframework.context.ApplicationListener;

 @SpringBootApplication(exclude = { /*SecurityAutoConfiguration.class, */ DataSourceAutoConfiguration.class})
 public class FramewrokApplication {
     public static void main(String[] args) {

         ApplicationListener<ApplicationPreparedEvent> listener = new frameworkApplicationListener();
         (new SpringApplicationBuilder(new Object[0])).sources(new Class[]{FramewrokApplication.class}).listeners(new ApplicationListener[]{listener}).run(args);
     }
 }
