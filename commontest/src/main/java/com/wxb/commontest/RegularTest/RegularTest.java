package com.wxb.commontest.RegularTest;

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

        String time = "22:22:00";
        String[] split = time.split(":");
        String i = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]).toString();

        String testString = "LiMit";

        System.out.println(testString.replaceAll("(?i)limit", "23"));

//        Arrays.stream(regualr.split(" ?世界 我的* ")).forEach(System.out::println);

        String date = "94/12/12";
        System.out.println(date.replaceAll("(\\d{4}|\\d{2})\\.(\\d{2})\\.(\\d{2})", "$1-$2-$3"));

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

}
