package com.wxb.commontest.modules.DesignMode.BuilderPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 11:02
 * @Version: 1.0
 */
public class ComputerBusiness {

    private Builder builder;

    public ComputerBusiness(Builder builder){
        this.builder = builder;
    }

    public Computer contruct(){

        builder.buildGraphics();
        builder.buildMainBoard();

        return builder.getComputer();
    }

}
