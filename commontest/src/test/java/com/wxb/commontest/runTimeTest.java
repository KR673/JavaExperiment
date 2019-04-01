package com.wxb.commontest;

import com.wxb.commontest.annotationTest.RumTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/12 10:55
 * @Version: 1.0
 */
public class runTimeTest extends CommontestApplicationTests{

    @Autowired
    private RumTest rumTest;

    @Test
    public void abc() {

        rumTest.foreachTest();
    }

    @Test
    public void test2(){
        RumTest rumTest1 = new RumTest();
        rumTest1.foreachTest();
    }
}
