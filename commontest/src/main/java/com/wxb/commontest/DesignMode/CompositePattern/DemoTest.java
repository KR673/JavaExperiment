package com.wxb.commontest.DesignMode.CompositePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/1 15:43
 * @Version: 1.0
 */
public class DemoTest {

    public static void main(String[] args) {

        Floder book = new Floder("笔记");

         File note1 = new File("noteA.md","[toc]");
         File note2 = new File("noteB.md","[toc]");

         book.add(note1);
         book.add(note2);

         Floder book1 = new Floder("笔记A");
         book.add(book1);

         book1.add(note1);
         book1.add(note2);

         book.print();
    }
}
