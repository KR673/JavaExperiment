package com.wxb.commontest.DesignMode.FactoryPattern.FactoryMethodPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/20 17:11
 * @Version: 1.0
 */
public class PatternDemo {
    public static void main(String[] args) {
        CarFactory factory = new BmwFactory();
        System.out.println(factory.product());
    }
}
