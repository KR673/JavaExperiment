package com.wxb.commontest.modules.SerializableTest;

import java.io.*;
import java.nio.file.FileVisitOption;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/23 11:34
 * @Version: 1.0
 */
public class ReadeObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileOutputStream = new FileInputStream("E://var//param.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);

        Param param = (Param) objectInputStream.readObject();

        System.out.println("load");

    }
}
