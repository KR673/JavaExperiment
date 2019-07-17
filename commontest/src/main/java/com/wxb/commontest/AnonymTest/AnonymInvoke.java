package com.wxb.commontest.AnonymTest;

import org.springframework.aop.scope.ScopedProxyUtils;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/20 10:54
 * @Version: 1.0
 */
public class AnonymInvoke {

    public static void main(String[] args) {
        new AnonymTest(){
            public void getName(String name){
                System.out.println(name);
            }
        }.getName("abcbc");
    }
}
