package com.wxb.commontest.modules.DesignMode.MediatorPattern;

import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/31 17:16
 * @Version: 1.0
 */
@Data
public class ChatTool extends ChatTools{

    private MemberA memberA;
    private MemberB memberB;

    @Override
    public void declare(String message, Member member) {

        if(member == memberA){
            memberB.getMessage(message);
        }else if(member == memberB){
            memberA.getMessage(message);
        }

    }
}
