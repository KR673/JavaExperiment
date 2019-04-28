package com.wxb.commontest.MathTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/23 17:14
 * @Version: 1.0
 */
public class MathTest {
    public static void main(String[] args) {
        long a = -0;
        long b = 333;

        double c=  (double) a / b;

        System.out.println(c);


        System.out.println(String.format("%.2f", (double)a / b));
    }

}
