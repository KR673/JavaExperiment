package com.wxb.commontest.util;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: list转map, 以指定字段做键值
 * @Author: WangXiaoBo
 * @Date: 2019/8/23 11:56
 * @Version: 1.0
 */
public class ListToMap {
    public static <E> Map<Object,E> getMap(List<E> a, String fileName) throws Exception {

        if(CollectionUtils.isEmpty(a)){
            return new HashMap<>();
        }

        Field field = a.get(0).getClass().getDeclaredField(fileName);

        Class.forName("abc");

        field.setAccessible(true);
        field.get(a.get(0));

        return a.stream().collect(Collectors.toMap(t -> {
            try {
                return field.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 0;
            }
        }, t -> t, (v1, v2) -> v1));
    }
}
