package com.wxb.commontest.modules.ThreadTest;


/**
 * @Description: 并发编程以及synchronized关键字的使用
 * @Author: WangXiaoBo
 * @Date: 2019/2/14 11:24
 * @Version: 1.0
 */
public class ThreadTest {

    static ThreadLocal<String> a = new ThreadLocal<>();
    static ThreadLocal<String> b = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(Thread.currentThread());
        }).run();
        new Thread(() -> {
            System.out.println(Thread.currentThread());
        }).run();
        a.set("a");
        Thread.sleep(100);
        System.out.println("main" + Thread.currentThread());
        System.out.println("main" + a.get());
    }
}

