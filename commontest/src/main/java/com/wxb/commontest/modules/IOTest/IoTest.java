package com.wxb.commontest.modules.IOTest;

import java.io.*;
import java.util.ArrayList;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/28 15:14
 * @Version: 1.0
 */
public class IoTest {

    static String aaaPath = "C:\\Users\\lenovo\\Desktop\\aaa.txt";

    public static void main(String[] args) throws IOException {

        File file = new File(aaaPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        ArrayList<Object> aa = new ArrayList<>();
        InputStreamReader gb2312 = new InputStreamReader(fileInputStream, "GB2312");
        BufferedReader bufferedReader = new BufferedReader(gb2312);

        System.out.println(bufferedReader.readLine());
    }

}
