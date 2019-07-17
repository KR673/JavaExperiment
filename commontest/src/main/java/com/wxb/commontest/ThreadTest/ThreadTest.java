package com.wxb.commontest.ThreadTest;


import org.aspectj.weaver.ast.Var;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 并发编程以及synchronized关键字的使用
 * @Author: WangXiaoBo
 * @Date: 2019/2/14 11:24
 * @Version: 1.0
 */
public class ThreadTest {

    private static CountDownLatch startLatch = new CountDownLatch(10);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    public static void main(String[] args) throws InterruptedException {

        //FutureTask<Object> task = new FutureTask<>(() -> {String abc = "";System.out.println("jjj"); return null;});

        Runnable runnable = new MyRunnable();
//        Runnable runnable2 = new MyRunnable(); //如果new两个MyRunnable对象使用thread调用, 则synchronized关键字不起作用, 因为synchronized锁定的是一个对象

        long begin = System.currentTimeMillis();
        new Thread(runnable, "A").start();

        long end = System.currentTimeMillis();

        System.out.println(end - begin);

        for (int i =1 ; i <= 10 ; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());}).start();
        }
        startLatch.await();
        System.out.println("结束");

        //new Thread(runnable, "B").start();
//        try {
//            System.out.println(task.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            for (long j = 0; j < 2000000000; j++) {
                j += 1;
                j *= 3;
            }
        }
        System.out.println(12);
    }
}