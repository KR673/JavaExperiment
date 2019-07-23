package com.wxb.commontest.DesignMode.BuilderPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 11:04
 * @Version: 1.0
 */
public class PatternDemo {

    public static void main(String[] args) {
        //配置一个高端电脑
        Computer computer = new ComputerBusiness(new HighConfiguration()).contruct();
        System.out.println(computer.getGraphics());

    }
}
