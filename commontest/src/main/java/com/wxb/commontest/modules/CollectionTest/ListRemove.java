package com.wxb.commontest.modules.CollectionTest;

import java.util.ArrayList;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/28 14:16
 * @Version: 1.0
 */
public class ListRemove {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        ArrayList<Integer> b = new ArrayList<>() {{

        }};

        a.removeAll(b);

        System.out.println(a);
    }
}
