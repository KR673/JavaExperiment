package com.wxb.commontest.annotationTest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/12 9:24
 * @Version: 1.0
 */
@Component
public class RunTest {

    @RunTime
    public void foreachTest(){

        List hundread = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            hundread.add("1");
        }

        hundread.stream().map(t -> t + "1").collect(Collectors.toList());
        System.out.println("执行完毕");
    }

}
