package com.wxb.commontest.DesignMode.BuilderPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 11:00
 * @Version: 1.0
 */
public class LowConfiguration extends Builder{

    @Override
    public void buildMainBoard() {
        computer.setMainBoard("低端主板");
    }

    @Override
    public void buildGraphics() {
        computer.setGraphics("低端显卡");
    }
}
