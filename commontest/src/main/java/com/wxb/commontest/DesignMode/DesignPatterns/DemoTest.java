package com.wxb.commontest.DesignMode.DesignPatterns;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 14:54
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) {
        Hander manager = new Manager();
        Hander generalManager = new GeneralManager();
        Hander president = new President();

        manager.setSuccess(generalManager);
        generalManager.setSuccess(president);

        System.out.println(manager.handerFeeRequest("张三", 1));
        System.out.println(manager.handerFeeRequest("李四", 3));
        System.out.println(manager.handerFeeRequest("王五", 4));
    }
}
