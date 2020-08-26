//package com.wxb.commontest.modules.lockOwnImpl;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.stream.IntStream;
//
///**
// * @Description: 作用描述
// * @Author: WangXiaoBo
// * @Date: 2019/8/26 14:34
// * @Version: 1.0
// */
//public class CounterRun {
//    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//        ExecutorService threadPool = Executors.newFixedThreadPool(100);
//
//        IntStream.range(1, 100)
//                .forEach(i -> threadPool.submit(() -> IntStream.range(0, 10000)
//                        .forEach(j -> counter.increment())));
//        threadPool.shutdown();
//        Thread.sleep(2000);
//        System.out.println(counter.getCount());
//    }
//}
