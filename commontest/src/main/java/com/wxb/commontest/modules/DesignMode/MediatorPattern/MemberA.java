package com.wxb.commontest.modules.DesignMode.MediatorPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 17:16
 * @Version: 1.0
 */
public class MemberA extends Member{

    public MemberA(ChatTools chatTools){
        this.chatTool = chatTools;
    }

    public void declear(String message){
        chatTool.declare(message, this);
    }

    public void getMessage(String message){
        System.out.println("A得到消息 : " + message);
    }
}
