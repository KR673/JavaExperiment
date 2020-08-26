package com.wxb.commontest.modules.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> run = new FutureTask<>(new callTest());
        new Thread(run).start();

        System.out.println(run.get());
        System.out.println("main end");
    }
}

class callTest implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("aaa");
        Thread.sleep(1000);
        return 1;

    }
}
