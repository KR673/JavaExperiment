package com.wxb.commontest.modules.DesignMode.ProtoTypePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 16:26
 * @Version: 1.0
 */
public abstract class Product implements Cloneable {

    public abstract void method();
    public abstract Product getClone();

}
