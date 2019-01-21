 package com.yatop.lambda;

 import com.yatop.lambda.framework.listener.LambdaApplicationListener;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
 import org.springframework.boot.builder.SpringApplicationBuilder;
 import org.springframework.boot.context.event.ApplicationPreparedEvent;
 import org.springframework.context.ApplicationListener;

 @SpringBootApplication(exclude = { /*SecurityAutoConfiguration.class, */ DataSourceAutoConfiguration.class})
 public class LambdaApplication {
     public static void main(String[] args) {

         ApplicationListener<ApplicationPreparedEvent> listener = new LambdaApplicationListener();
         (new SpringApplicationBuilder()).sources(new Class[]{LambdaApplication.class}).listeners(new ApplicationListener[]{listener}).run(args);
     }
 }
