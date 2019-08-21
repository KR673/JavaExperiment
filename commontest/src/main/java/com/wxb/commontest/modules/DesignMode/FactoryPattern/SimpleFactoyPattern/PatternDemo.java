package com.wxb.commontest.modules.DesignMode.FactoryPattern.SimpleFactoyPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/20 16:58
 * @Version: 1.0
 */
public class PatternDemo {
    public static void main(String[] args) {
        System.out.println(CarFactory.getCar("benz").product());
    }
}
