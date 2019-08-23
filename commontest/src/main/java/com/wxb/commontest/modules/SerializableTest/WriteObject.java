package com.wxb.commontest.modules.SerializableTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/23 11:28
 * @Version: 1.0
 */
public class WriteObject {
    public static void main(String[] args) throws IOException {
        Param param = new Param();

        FileOutputStream fileOutputStream = new FileOutputStream("E://var//param.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(param);
        System.out.println("保存");

        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
