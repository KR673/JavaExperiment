package com.wxb.commontest.AspectTest;


import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/20 14:33
 * @Version: 1.0
 */
public class AspectStart implements InvocationHandler {

    private Objects source;



    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("before");
        Object invoke = method.invoke(source, objects);

        return null;
    }


}
