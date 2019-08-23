package com.wxb.commontest.modules.SerializableTest;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/23 11:23
 * @Version: 1.0
 */
@Data
public class Param implements Serializable {

    private static final long serialVersionUID = -5110520861977154991L;
    String name;
    Integer age;

}
