package com.wxb.commontest;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/16 9:15
 * @Version: 1.0
 */
public class QuartzTestStart {

    public static void main(String[] args) throws SchedulerException {
        //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class).withIdentity("myJob").build();
        //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? "))
                .build();

        //创建schedule实例
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
