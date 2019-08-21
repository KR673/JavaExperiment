package com.wxb.commontest.modules.DesignMode.StatePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/18 20:45
 * @Version: 1.0
 */
public class ModeTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.isYounth();
        context.walk();
        context.walk();
        context.isAgedness();
        context.walk();
    }
}
