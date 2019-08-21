package com.wxb.commontest.modules.annotationTest;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/12 9:20
 * @Version: 1.0
 */
@Aspect
@Component
public class RunTimeAspect {

    @Pointcut("@annotation(com.wxb.commontest.modules.annotationTest.RunTime)")
    public void runPointCut(){
    }

    @Around("runPointCut()")
    public Object ifBegin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long beginTime = System.currentTimeMillis();

        proceedingJoinPoint.proceed();

        long entTime = System.currentTimeMillis();

        System.out.println("代码执行时间 : " + (entTime - beginTime));

        return null;
    }
}
