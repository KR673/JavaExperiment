package com.wxb.commontest.modules.annotationTest;

import org.springframework.stereotype.Service;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/4/1 16:18
 * @Version: 1.0
 */
@Service
public class RunInterfaceImpl implements RunInterface {

    @Override
    public void foreach() {
        System.out.println("接口方法执行");
    }
}
