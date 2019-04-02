package com.wxb.commontest;

import com.wxb.commontest.annotationTest.RunInterface;
import com.wxb.commontest.annotationTest.RunTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 自定义注解
 * @Author: WangXiaoBo
 * @Date: 2019/2/12 10:55
 * @Version: 1.0
 */
public class runTimeTest extends CommontestApplicationTests{

    @Autowired
    private RunTest runTest;

    @Autowired
    private RunInterface runInterface;

    @Test
    public void testWithICO() {

        runTest.foreachTest();
    }

    @Test
    public void testWithNew(){
        RunTest runTest1 = new RunTest();
        runTest1.foreachTest();
    }

    @Test
    public void runInterfaceTest(){
        runInterface.foreach();
        //注解在接口中不能继承
    }
}
