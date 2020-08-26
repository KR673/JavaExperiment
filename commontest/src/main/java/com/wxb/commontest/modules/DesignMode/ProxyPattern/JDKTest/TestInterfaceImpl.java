package com.wxb.commontest.modules.DesignMode.ProxyPattern.JDKTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/22 14:25
 * @Version: 1.0
 */
public class TestInterfaceImpl implements TestInterface{

    @Override
    public void save() {
        System.out.println("save");
        find();
        System.out.println("class : " + this.getClass());
    }

    @Override
    public void find() {
        System.out.println("find");
    }
}
