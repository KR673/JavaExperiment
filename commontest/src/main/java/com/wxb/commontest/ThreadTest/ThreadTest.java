package com.wxb.commontest.ThreadTest;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/14 11:24
 * @Version: 1.0
 */
public class ThreadTest {
    public static void main(String[] args)  {

        FutureTask<Object> task = new FutureTask<>(() -> {String abc = "";System.out.println("jjj"); return null;});

        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class MyRunnable implements Runnable{

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Object object = new Object();

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                synchronized (object){
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