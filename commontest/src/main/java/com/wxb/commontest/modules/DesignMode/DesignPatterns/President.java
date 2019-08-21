package com.wxb.commontest.modules.DesignMode.DesignPatterns;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 14:52
 * @Version: 1.0
 */
public class President extends Hander {
    @Override
    public String handerFeeRequest(String userName, Integer rank) {

        String str = "";

        if(rank == 3){
            str = "总裁处理了" + userName + "的请求";
        }else{
            str = userName + "请求直接通过";
        }

        return str;
    }
}
