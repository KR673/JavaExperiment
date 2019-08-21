package com.wxb.commontest.modules.DesignMode.MediatorPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 17:20
 * @Version: 1.0
 */
public class MemberB extends Member {
    public MemberB(ChatTools chatTools){
        this.chatTool = chatTools;
    }

    public void declear(String message){
        chatTool.declare(message, this);
    }

    public void getMessage(String message){
        System.out.println("B得到消息 : " + message);
    }
}
