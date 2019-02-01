package com.yatop.lambda.portal.common.config;

import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

//@Configuration
public class AsyncExecutorPoolConfig extends AsyncConfigurerSupport {
//    @Bean
//    public Executor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(20);
//        executor.setQueueCapacity(100);
//        executor.setKeepAliveSeconds(30);
//        executor.setThreadNamePrefix("asyncTaskExecutor-");
//
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        return executor;
//    }
}