package com.wxb.commontest.SchduleTest;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/23 10:02
 * @Version: 1.0
 */
@RestController
@RequestMapping("/schdule")
public class EnableStartOrStop {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    private ScheduledFuture<?> future2;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/startCron")
    public String startCron() {
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/2 * * * * *"));
        System.out.println("DynamicTask.startCron()");
        return "startCron";
    }

    @RequestMapping("/startCron2")
    public String startCron2() {

        Runnable runnable = () -> {System.out.println("abc");
            System.out.println(Thread.currentThread().getName());};

        CronTrigger trigger = new CronTrigger("0/2 * * * * *");
        future2 = threadPoolTaskScheduler.schedule(runnable, trigger);

        System.out.println("DynamicTask.startCron()");
        return "startCron";
    }


    @RequestMapping("/stopCron")
    public String stopCron() {

        if (future != null) {
            future.cancel(true);
        }
        System.out.println("DynamicTask.stopCron()");
        return "stopCron";
    }

    @RequestMapping("/changeCron10")
    public String startCron10() {

        stopCron();// 先停止，在开启.
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/10 * * * * *"));
        System.out.println("DynamicTask.startCron10()");
        return "changeCron10";
    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.err.println("DynamicTask.MyRunnable.run()，" + new Date());
        }
    }

}
