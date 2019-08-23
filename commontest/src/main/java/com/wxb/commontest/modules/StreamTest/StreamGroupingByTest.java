package com.wxb.commontest.modules.StreamTest;


import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description: stream groupingBy 使用
 * @Author: WangXiaoBo
 * @Date: 2019/5/22 11:21
 * @Version: 1.0
 */

public class StreamGroupingByTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<ParamL> paramList = new ArrayList<>() /*{{
            add(new ParamL("a", 1, "a"));
            add(new ParamL("a", 1, "a"));
            add(new ParamL("b", 2, "b"));
            add(new ParamL("b", 2, "b"));
            add(new ParamL("a", 1, "a"));
            add(new ParamL("a", 1, "a"));
        }}*/;
        for (int i = 0; i < 300000; i++) {
            paramList.add(new ParamL(String.valueOf(i % 2600) , i % 2600, String.valueOf(i % 1000)));
        }

        List<ParamL> result = new ArrayList<>();

        Map<Integer, Map<String, Map<String, List<ParamL>>>> collect = paramList.stream()
                .collect(Collectors.groupingBy(ParamL::getAge,
                        Collectors.groupingBy(ParamL::getName,
                                Collectors.groupingBy(ParamL::getAaa))));


        List<Integer> collect1 = collect.entrySet()
                .stream()
                .map(t -> t.getKey())
                .collect(Collectors.toList());
        for (Integer integer : collect1) {
            List<String> collect2 = collect.get(integer).entrySet().stream()
                    .map(t -> t.getKey())
                    .collect(Collectors.toList());

            for (String s : collect2) {
                List<String> collect3 = collect.get(integer).get(s).entrySet().stream()
                        .map(t -> t.getKey())
                        .collect(Collectors.toList());

                for (String s1 : collect3) {
                    List<ParamL> paramLS = collect.get(integer).get(s).get(s1);
                    Integer b = 0;
                    String a = "0";
                    String c = "0";

                    for (ParamL paramL : paramLS) {
                        a = String.valueOf(Integer.valueOf(a) + Integer.valueOf(paramL.getName()));
                        b += paramL.getAge();
                        c = String.valueOf(Integer.valueOf(c) + Integer.valueOf(paramL.getAaa()));
                    }

                    ParamL instance = ParamL.getInstance();
                    instance.setName(a);
                    instance.setAge(b);
                    instance.setAaa(c);

                    result.add(instance);

                }
            }
        }

        System.out.println(result);

        Thread.sleep(1000 * 60 * 60);

    }

    public static int fun() throws IOException {


        return System.in.read();
    }

}

@Data
class ParamL{
    private String name;
    private Integer age;
    private String aaa;

    private static ParamL instance = new ParamL();

    private ParamL(){}

    public ParamL(String name, Integer age, String aaa) {
        this.name = name;
        this.age = age;
        this.aaa = aaa;
    }

    public static ParamL getInstance(){
        if(instance == null){
            instance = new ParamL();
        }
        return instance;
    }
}