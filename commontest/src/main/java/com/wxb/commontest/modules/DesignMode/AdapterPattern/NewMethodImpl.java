package com.wxb.commontest.modules.DesignMode.AdapterPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/29 17:10
 * @Version: 1.0
 */
public class NewMethodImpl implements NewMethod{

    private OldMethod adapter;

    public void setAdapter(OldMethod adapter){
        this.adapter = adapter;
    }

    @Override
    public String method() {
        return adapter.method();
    }
}
