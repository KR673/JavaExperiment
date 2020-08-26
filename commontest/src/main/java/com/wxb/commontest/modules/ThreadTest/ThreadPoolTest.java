package com.wxb.commontest.modules.ThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor tp = new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for (int f = 0; f < 15; f++) {
            tp.execute(() -> {
                try {
                    Thread.sleep(1000 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
