package com.wxb.commontest.NullPointerTest;

import java.util.HashMap;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/2 13:34
 * @Version: 1.0
 */
public class NullPointerTest {

    //valueOf
    public void valueOf(Integer number){
        System.out.println(String.valueOf(number));
    }

    //map
    public void mapKeyNull(Integer number){
        HashMap<String, String> map = new HashMap<>(){{
            put("a", "1");
            put("c", "1");
            put("b", "hh1");
        }};
        map.get(number);
    }

    //tostring
    public void toStringTest(Integer number){
        number.toString();
    }
}
