package com.wxb.commontest.modules.DesignMode.CompositePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/1 15:28
 * @Version: 1.0
 */
public abstract class Component {
    public abstract String getName();
    public abstract void add(Component component);
    public abstract void remover(Component component);
    public abstract void print();
    public abstract String getContent();

}
