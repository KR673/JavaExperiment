package com.wxb.commontest.DesignMode.StatePattern;

/**
 * @Description: 老年时代
 * @Author: WangXiaoBo
 * @Date: 2019/7/18 20:35
 * @Version: 1.0
 */
public class Agedness implements PresentAge {
    @Override
    public String walk() {
        return "三条腿";
    }
}
