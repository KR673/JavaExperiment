package com.wxb.commontest.modules.DesignMode.DesignPatterns;

import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 14:37
 * @Version: 1.0
 */
@Data
public abstract class Hander {

    private Hander success = null;

    public abstract String handerFeeRequest(String userName, Integer rank);
}
