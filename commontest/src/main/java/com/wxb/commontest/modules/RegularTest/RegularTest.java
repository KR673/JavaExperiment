package com.wxb.commontest.modules.RegularTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 正则测试
 * @Author: WangXiaoBo
 * @Date: 2019/2/18 13:44
 * @Version: 1.0
 */
public class RegularTest {
    public static void main(String[] args) {

        splitTest();
    }



    /**
     * @Description: 日期单数补零
     * @Author WangXiaoBo
     * @Param
     * @return
     */
    private void DateAddZero(){

        Pattern regualr = Pattern.compile("-(\\d)(?!\\d)");
        Matcher matcher =  regualr.matcher("1994-12-1");

        System.out.println(matcher.replaceAll("-0$1"));
    }
    /**
     * @Description: split
     * @Author WangXiaoBo
     * @Param
     * @return
     */
    private static void splitTest(){

            System.out.println("aabbcc".matches("a{2}b{2}c{2}"));

    }

}
