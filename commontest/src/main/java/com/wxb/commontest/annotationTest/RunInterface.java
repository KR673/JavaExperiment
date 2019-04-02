package com.wxb.commontest.annotationTest;

import org.springframework.stereotype.Service;

/**
 * @Description: 接口上添加注解测试
 * @Author: WangXiaoBo
 * @Date: 2019/4/1 16:17
 * @Version: 1.0
 */
public interface RunInterface {

    @RunTime
    void foreach();

}
