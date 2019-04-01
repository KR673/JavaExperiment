package com.wxb.commontest.StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/3/20 17:23
 * @Version: 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> lists = new ArrayList(){{
            add("作用");
            add("作用");
        }};

        System.out.println(lists.stream().distinct().collect(Collectors.toList()));
    }
}
