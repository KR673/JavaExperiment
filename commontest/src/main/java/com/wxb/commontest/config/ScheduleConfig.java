package com.wxb.commontest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/23 11:54
 * @Version: 1.0
 */
@Configuration
public class ScheduleConfig {

    @Bean("taskExecutor")
    public ThreadPoolTaskScheduler taskExecutor() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(20);
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(300);
        return executor;
    }

}
