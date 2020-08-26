package com.wxb.commontest.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SayHelloAndEnd {

    @Pointcut("execution(public * com.wxb.commontest.modules.SchduleTest..*.*(..))")
    public void say(){}

    @Before("execution(public * com.wxb.commontest.modules.SchduleTest..*.*(..))")
    public void doBefore(){
        System.out.println("hello");
    }

    @After("execution(public * com.wxb.commontest.modules.SchduleTest..*.*(..))")
    public void doAfter(){
        System.out.println("goodBye");
    }
}
