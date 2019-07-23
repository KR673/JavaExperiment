package com.wxb.commontest.DesignMode.BuilderPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 10:54
 * @Version: 1.0
 */
public abstract class Builder {

    protected Computer computer = new Computer();

    public abstract void buildMainBoard();
    public abstract void buildGraphics();

    public Computer getComputer(){
        return computer;
    }
}
