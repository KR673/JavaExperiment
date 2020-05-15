package com.wxb.commontest.pojo;
import com.wxb.commontest.modules.annotationTest.TypeOne;
import lombok.Data;

@Data
public class Person {

    @TypeOne
    private String name;

    private Integer age;


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
}
