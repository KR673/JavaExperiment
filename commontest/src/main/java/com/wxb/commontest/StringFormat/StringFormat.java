package com.wxb.commontest.StringFormat;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/3/18 18:02
 * @Version: 1.0
 */
public class StringFormat {

    public static void main(String[] args) {
        int minutes = 10;

        int hour = minutes / 60;
        int minute= minutes % 60;
        int seconds= minutes * 60 % 60;
        System.out.println(String.format("%02d:%02d:%02d", hour, minute, seconds));
    }
}
