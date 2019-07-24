package com.wxb.commontest.DesignMode.ProtoTypePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 17:37
 * @Version: 1.0
 */
public class PatternDemo {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ProductOne aaa = new ProductOne("aaa");
        ProductOne bbb = new ProductOne("bbb");
        manager.register("methodOne", aaa);
        manager.register("methodOnebbb", bbb);
        Product methodOne = manager.create("methodOne");

        ProductOne abcdefg = new ProductOne("abcdefg");

        Product clone = abcdefg.getClone();


    }
}
