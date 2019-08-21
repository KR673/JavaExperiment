package com.wxb.commontest.modules.RedisLock;

import com.wxb.commontest.CommontestApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class redisTestTest extends CommontestApplicationTests {

    @Autowired
    private redisTest redisTest;

    @Test
    public void redisTest(){
        redisTest.redisTest();
    }

}