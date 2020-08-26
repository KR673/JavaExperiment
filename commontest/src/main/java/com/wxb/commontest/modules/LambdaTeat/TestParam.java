package com.wxb.commontest.modules.LambdaTeat;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
public class TestParam {

    private String name;
    private Integer age;

    private boolean aaa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAaa() {
        return aaa;
    }

    public void setAaa(boolean aaa) {
        this.aaa = aaa;
    }

    public static <T, R> List<R> getList(List<T> param, Function<T, R> f, Predicate<T> judge){
        return param.stream()
                .filter(judge)
                .map(f)
                .collect(Collectors.toList());
    }


    public static <T, U, R> R getValueFromMap(BiFunction<Map,U, R> something, Map a, U u){
        return something.apply(a, u);
    }

    public static void main(String[] args) {

        List<TestParam> testparams = new ArrayList<>();

        testparams.add(new TestParam() {{
            setName("1");
            setAge(1);
        }});

        List<Integer> list = getList(testparams, TestParam::getAge, testParam -> Objects.equals(testParam.getAge(), "sdfsdf"));
        List<Integer> lists = getList(testparams, TestParam::getAge, s -> true);

        System.out.println(lists);
    }

}
