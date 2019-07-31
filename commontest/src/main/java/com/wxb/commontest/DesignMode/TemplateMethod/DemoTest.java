package com.wxb.commontest.DesignMode.TemplateMethod;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 11:56
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) {
        Integer a = 2;
        Integer b = 3;

        //加法
        System.out.println(new Addition().templageMethod(a, b));
        //乘法
        System.out.println(new Multiplication().templageMethod(a, b));
    }
}
