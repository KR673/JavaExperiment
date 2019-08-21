package com.wxb.commontest.modules.DesignMode.AdapterPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/29 17:12
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) {
        OldMethod oldMethod = new OldMethod();

         NewMethodImpl newMethod = new NewMethodImpl();
         newMethod.setAdapter(oldMethod);
        System.out.println(newMethod.method());
    }
}
