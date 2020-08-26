package com.wxb.commontest.junit;

import com.wxb.commontest.SpringBootStartApplicationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitAnnounteTest extends SpringBootStartApplicationTest {

    public String message;

    @Before
    public void provideMessage(){
        message = "before annount";
    }

    @After
    public void afterMessage(){
        System.out.println("after message");
    }

    @Test
    public void saySomeThing(){
        System.out.println(message);
    }

}
