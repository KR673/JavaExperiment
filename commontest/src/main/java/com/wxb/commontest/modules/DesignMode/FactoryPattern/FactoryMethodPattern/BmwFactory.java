package com.wxb.commontest.modules.DesignMode.FactoryPattern.FactoryMethodPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/20 17:11
 * @Version: 1.0
 */
public class BmwFactory implements CarFactory {
    @Override
    public String product() {
        return "生产一辆宝马";
    }
}
