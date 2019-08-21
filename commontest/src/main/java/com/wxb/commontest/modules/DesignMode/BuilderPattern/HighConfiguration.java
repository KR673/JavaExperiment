package com.wxb.commontest.modules.DesignMode.BuilderPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 10:57
 * @Version: 1.0
 */
public class HighConfiguration extends Builder {
    @Override
    public void buildMainBoard() {
        computer.setMainBoard("高端主板");
    }

    @Override
    public void buildGraphics() {
        computer.setGraphics("高端显卡");
    }
}
