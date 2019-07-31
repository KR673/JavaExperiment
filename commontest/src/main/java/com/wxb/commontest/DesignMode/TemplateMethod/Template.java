package com.wxb.commontest.DesignMode.TemplateMethod;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 11:49
 * @Version: 1.0
 */
public abstract class Template {

    public abstract Integer method(Integer a , Integer b);

    public Integer templageMethod(Integer a, Integer b){
        return method(a, b);
    }

}
