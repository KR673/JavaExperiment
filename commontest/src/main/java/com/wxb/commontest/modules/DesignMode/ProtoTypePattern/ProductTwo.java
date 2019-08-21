package com.wxb.commontest.modules.DesignMode.ProtoTypePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 17:37
 * @Version: 1.0
 */
public class ProductTwo extends Product {
    @Override
    public void method() {
        System.out.println("执行方法二");
    }

    @Override
    public Product getClone() {

        try {
            return (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }
}
