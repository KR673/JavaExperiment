package com.wxb.commontest;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/6/18 16:27
 * @Version: 1.0
 */
@Data
public class Param {

    @NotNull
    private String name;

    @Range(max = 100, message = "age小于100")
    private Integer age;

    private static String address = "hn";

    public Param() {}

    public void setNaame(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
