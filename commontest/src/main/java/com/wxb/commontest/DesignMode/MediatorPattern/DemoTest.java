package com.wxb.commontest.DesignMode.MediatorPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 17:29
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) {
        ChatTool chatTool = new ChatTool();

        MemberA memberA = new MemberA(chatTool);
        MemberB memberB = new MemberB(chatTool);

        chatTool.setMemberA(memberA);
        chatTool.setMemberB(memberB);

        memberA.declear("hello");
    }
}
