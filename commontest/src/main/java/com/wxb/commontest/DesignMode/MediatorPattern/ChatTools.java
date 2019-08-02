package com.wxb.commontest.DesignMode.MediatorPattern;

import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 17:12
 * @Version: 1.0
 */
public abstract class ChatTools {
    public abstract void declare(String message, Member member);
}
