package com.wxb.commontest.modules.String;

import java.nio.charset.Charset;

/**
 * @Description: 编码测试
 * @Author: WangXiaoBo
 * @Date: 2019/9/2 14:48
 * @Version: 1.0
 */
public class Encode {

    public static void main(String[] args) {

        System.out.println("123多多𝄞".length());
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("sun.jnu.encoding"));
    }
}
