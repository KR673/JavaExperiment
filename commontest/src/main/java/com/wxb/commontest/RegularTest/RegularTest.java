package com.wxb.commontest.RegularTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/18 13:44
 * @Version: 1.0
 */
public class RegularTest {
    public static void main(String[] args) {

        String time = "22:22:00";
        String[] split = time.split(":");
        String i = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]).toString();

//        Pattern regualr = Pattern.compile("(?>=-)\\d");
//        Matcher matcher =  regualr.matcher("1994-12-1");
//
//        String testString = "LiMit";
//
//        System.out.println(testString.replaceAll("(?i)limit", "23"));
//
//        //Arrays.stream(regualr.split(" ?世界 我的* ")).forEach(System.out::println);
//
//            System.out.println(matcher.replaceAll("-0$1"));
//
///*
//        String date = "94/12/12";
//        System.out.println(date.replaceAll("(\\d{4}|\\d{2})\\.(\\d{2})\\.(\\d{2})", "$1-$2-$3"));
//*/

    }
}
