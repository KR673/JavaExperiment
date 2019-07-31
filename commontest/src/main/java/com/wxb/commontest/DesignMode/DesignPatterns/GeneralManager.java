package com.wxb.commontest.DesignMode.DesignPatterns;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 14:46
 * @Version: 1.0
 */
public class GeneralManager extends Hander {
    @Override
    public String handerFeeRequest(String userName, Integer rank) {

        String str = "";

        if(rank == 2){
            str = "总经理处理了" + userName + "的请求";
        }else{
            if(getSuccess() != null){
                return getSuccess().handerFeeRequest(userName, rank);
            }
        }

        return str;
    }
}
