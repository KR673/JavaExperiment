package com.wxb.commontest.modules.queueTest;

import java.util.concurrent.ArrayBlockingQueue;

public class First {
    public static void main(String[] args) {

        ArrayBlockingQueue queueb = new ArrayBlockingQueue<String>(10);
        queueb.add("a");
        queueb.add("b");
        System.out.println(queueb.element());
    }
}
