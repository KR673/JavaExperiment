package com.wxb.commontest.DesignMode.MementoPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 21:18
 * @Version: 1.0
 */
public class DemoTest {

    public static void main(String[] args) {

        MementoCaretaker mementoCaretaker = new MementoCaretaker();
        SteamName steamName = new SteamName("1");
        mementoCaretaker.addMemento(steamName.save());
        SteamName steamName1 = new SteamName("2");
        mementoCaretaker.addMemento(steamName1.save());

        //恢复
        steamName1.restore(mementoCaretaker.getMemento(0));
        System.out.println(steamName1.getName());
    }
}
