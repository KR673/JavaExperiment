package com.wxb.commontest.modules.IOTest;

import java.io.*;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/28 15:14
 * @Version: 1.0
 */
public class IoTest {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Administrator\\Desktop\\aaa.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        InputStreamReader gb2312 = new InputStreamReader(fileInputStream, "GB2312");
        BufferedReader bufferedReader = new BufferedReader(gb2312);

        System.out.println(bufferedReader.readLine());
    }

}
