package com.wxb.commontest.DesignMode.CommandPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 18:06
 * @Version: 1.0
 */
public class CommandImpl implements Command{

    private CommandReceiver commandReceiver;

    public CommandImpl(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String execute() {
        return commandReceiver.excute();
    }
}
