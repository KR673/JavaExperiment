package com.wxb.commontest.modules.ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        atomicInteger.getAndAdd(3);
    }

}
