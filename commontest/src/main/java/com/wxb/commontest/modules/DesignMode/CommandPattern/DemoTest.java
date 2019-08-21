package com.wxb.commontest.modules.DesignMode.CommandPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 18:16
 * @Version: 1.0
 */
public class DemoTest {

    public static void main(String[] args) {
        CommandImpl command = new CommandImpl(new CommandReceiver());
        Invoke invoke = new Invoke(command);
        System.out.println(invoke.action());
    }
}
