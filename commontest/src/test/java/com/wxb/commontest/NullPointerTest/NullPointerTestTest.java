package com.wxb.commontest.NullPointerTest;

import org.junit.Test;

public class NullPointerTestTest {

    @Test
    public void valueOf() {
        new NullPointerTest().valueOf(null);
    }

    @Test
    public void mapKeyNull() {
        new NullPointerTest().mapKeyNull(null);
    }

    @Test
    public void toStringTest() {
        new NullPointerTest().toStringTest(null);
    }
}