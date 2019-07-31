package com.wxb.commontest.DesignMode.TemplateMethod;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 11:52
 * @Version: 1.0
 */
public class Addition  extends Template{
    @Override
    public Integer method(Integer a, Integer b) {
        return a + b;
    }
}
