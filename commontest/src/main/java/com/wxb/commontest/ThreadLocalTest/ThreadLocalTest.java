package com.wxb.commontest.ThreadLocalTest;

import java.awt.print.PrinterAbortException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/16 16:15
 * @Version: 1.0
 */
public class ThreadLocalTest {

    private static Integer status = 0;

    public static void main(String[] args){

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    numberAdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void numberAdd() throws InterruptedException {
        if(status == 1){
            System.out.println("其他线程正在执行");
            return;
        }
        status = 1;

        System.out.println(Thread.currentThread().getName() + ": 正在执行");
        Thread.sleep(10);
        status = 0;
    }
}
