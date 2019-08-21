package com.wxb.commontest.modules.SchduleTest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/23 9:32
 * @Version: 1.0
 */
@EnableScheduling
@Component
@EnableAsync
public class AsyncTest {

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void configureTasks() throws InterruptedException {
        System.out.println("1 : " + Thread.currentThread().getName());
        System.err.println("执行静态定时任务时间: " + "5s");
    }

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void configureTasks2() {
        System.out.println("2 : " + Thread.currentThread().getName());

        System.err.println("执行静态定时任务时间: " + "1s");
    }

}
