package com.wxb.commontest.modules.DesignMode.CommandPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 18:14
 * @Version: 1.0
 */
public class Invoke {

    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public String action(){
        return command.execute();
    }
}
