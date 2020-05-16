package com.wxb.commontest.modules.RabbitTest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/11/5 10:34
 * @Version: 1.0
 */
// 使用时注释打开，不然一直报连接拒绝
//@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiverController {
    @RabbitHandler
    public void process(Map testMessage){
        System.err.println("DirectReceiver : " + testMessage.toString());
    }
}
