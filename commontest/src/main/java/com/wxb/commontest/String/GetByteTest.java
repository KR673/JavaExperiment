package com.wxb.commontest.String;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.io.UnsupportedEncodingException;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/27 16:30
 * @Version: 1.0
 */
public class GetByteTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String abc = "够";

        for (int i = 0; i < abc.getBytes("utf-8").length; i++) {
            System.out.println(abc.getBytes("utf-8")[i]);
        }
    }

}
