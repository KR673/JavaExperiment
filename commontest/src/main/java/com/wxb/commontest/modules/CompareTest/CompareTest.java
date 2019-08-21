package com.wxb.commontest.modules.CompareTest;

import java.util.Comparator;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/3/30 10:22
 * @Version: 1.0
 */
public class CompareTest {
    public static void main(String[] args) {

        Comparator<Integer> comparator2 = Comparator.comparing(Integer::intValue);

        System.out.println(comparator2.compare(3, 2));


    }

}
