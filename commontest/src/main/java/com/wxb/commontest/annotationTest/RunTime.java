package com.wxb.commontest.annotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/12 9:16
 * @Version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunTime {
    String value() default "";
}
