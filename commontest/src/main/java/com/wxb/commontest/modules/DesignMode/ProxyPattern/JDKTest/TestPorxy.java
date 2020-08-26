package com.wxb.commontest.modules.DesignMode.ProxyPattern.JDKTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/22 14:01
 * @Version: 1.0
 */
public class TestPorxy implements InvocationHandler {

    private Object targer;

    public TestPorxy(Object param) {
        super();
        this.targer = param;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(targer, args);
        System.out.println("after");
        return result;
    }
}
