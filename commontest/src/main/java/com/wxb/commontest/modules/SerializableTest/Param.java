package com.wxb.commontest.modules.SerializableTest;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/23 11:23
 * @Version: 1.0
 */
@Data
@Component
public class Param implements Serializable {

    private static final long serialVersionUID = -5110520861977154991L;
    String name;
    Integer age;

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
