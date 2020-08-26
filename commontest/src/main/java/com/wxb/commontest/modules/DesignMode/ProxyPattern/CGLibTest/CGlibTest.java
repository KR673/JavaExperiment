package com.wxb.commontest.modules.DesignMode.ProxyPattern.CGLibTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/22 16:40
 * @Version: 1.0
 */
public class CGlibTest implements MethodInterceptor {

    private Object target1;

    public Object getInstance(final Object target) {
        this.target1 = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target1.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("after");
        return result;
    }

}
