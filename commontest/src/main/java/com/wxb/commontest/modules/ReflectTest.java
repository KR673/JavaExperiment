package com.wxb.commontest.modules;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/24 13:48
 * @Version: 1.0
 */
public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException {

        BanZhuRenParam banZhuRenParam = new BanZhuRenParam(){{
            setTypeId("typeId");
            setPage("page");
            setLimit("limit");
        }};

        Arrays.stream(BanZhuRenParam.class.getDeclaredFields()).forEach(System.out::println);

        for (Field a : BanZhuRenParam.class.getDeclaredFields()){
            a.setAccessible(true);
            System.out.println(a.get(banZhuRenParam));
        }


    }
}
