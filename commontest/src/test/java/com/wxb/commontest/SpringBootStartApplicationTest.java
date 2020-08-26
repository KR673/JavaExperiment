package com.wxb.commontest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommontestApplication.class)
public class SpringBootStartApplicationTest {

    public SpringBootStartApplicationTest(){
        System.setProperty("es.set.netty.runtime.available.processors","false");
    }
}
