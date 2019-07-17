package com.wxb.commontest.DesignMode.StategyPattern;

/**
 * @Description: 测试
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:50
 * @Version: 1.0
 */
public class ModeTest {
    public static void main(String[] args) {

        Context context = new Context();
        //普通用户
        System.out.println("普通用户下载 : " + context.StategyInvoke(MemberEnum.NOT_MEMBER));
        System.out.println("会员用户下载 : " + context.StategyInvoke(MemberEnum.MEMBER));

    }
}
