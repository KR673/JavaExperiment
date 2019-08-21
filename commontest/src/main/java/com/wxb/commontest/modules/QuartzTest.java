package com.wxb.commontest.modules;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/16 9:13
 * @Version: 1.0
 */
public class QuartzTest implements Job {

    public QuartzTest() throws SchedulerException {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("testtesttest");
    }

}
