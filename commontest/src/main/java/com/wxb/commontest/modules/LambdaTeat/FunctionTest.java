package com.wxb.commontest.modules.LambdaTeat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/3/12 11:47
 * @Version: 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {

        List<Integer> objects = new ArrayList<>() {{
            add(1);
            add(2);
        }};

        List<Integer> collect = objects.stream().map(t -> t + 1).collect(Collectors.toList());
        System.out.println(collect);

    }

}
