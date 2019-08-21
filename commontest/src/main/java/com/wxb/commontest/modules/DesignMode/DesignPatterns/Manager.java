package com.wxb.commontest.modules.DesignMode.DesignPatterns;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 14:41
 * @Version: 1.0
 */
public class Manager extends Hander{
    @Override
    public String handerFeeRequest(String userName, Integer rank) {

        String str = "";

        if(rank == 1){
            str = "经理处理了" + userName + "的请求";
        }else{
            if(getSuccess() != null){
                return getSuccess().handerFeeRequest(userName, rank);
            }else{
                str = "无人处理";
            }
        }

        return str;
    }
}
