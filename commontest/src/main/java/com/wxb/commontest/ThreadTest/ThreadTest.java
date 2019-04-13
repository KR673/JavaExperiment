package com.wxb.commontest.ThreadTest;


/**
 * @Description: 并发编程以及synchronized关键字的使用
 * @Author: WangXiaoBo
 * @Date: 2019/2/14 11:24
 * @Version: 1.0
 */
public class ThreadTest {
    public static void main(String[] args)  {

        //FutureTask<Object> task = new FutureTask<>(() -> {String abc = "";System.out.println("jjj"); return null;});

        Runnable runnable = new MyRunnable();
//        Runnable runnable2 = new MyRunnable(); //如果new两个MyRunnable对象使用thread调用, 则synchronized关键字不起作用, 因为synchronized锁定的是一个对象

        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();
//        try {
//            System.out.println(task.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}


class MyRunnable implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                synchronized(this){
                    for (int j = 0; j < 3; j++) {
                        System.out.println("子线程ID："+Thread.currentThread().getId() + "--" + i);
                    }
                }
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}