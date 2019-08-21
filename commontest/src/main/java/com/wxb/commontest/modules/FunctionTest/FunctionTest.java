package com.wxb.commontest.modules.FunctionTest;

import java.util.function.Function;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/3/12 11:47
 * @Version: 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<String , String> abc = a -> a + "11";

        System.out.println(abc.apply("34"));

    }

}
