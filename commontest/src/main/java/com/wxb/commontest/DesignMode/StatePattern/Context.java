package com.wxb.commontest.DesignMode.StatePattern;

/**
 * @Description: 环境
 * @Author: WangXiaoBo
 * @Date: 2019/7/18 20:36
 * @Version: 1.0
 */
public class Context {

    private PresentAge presentAge;

    public void  isYounth(){
        presentAge = new Younth();
    }
    public void  isAgedness(){
        presentAge = new Agedness();
    }

    public void walk(){
        System.out.println(presentAge.walk());
    }
}
