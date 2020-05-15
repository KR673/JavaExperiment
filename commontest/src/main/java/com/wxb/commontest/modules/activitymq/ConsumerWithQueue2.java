package com.wxb.commontest.modules.activitymq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerWithQueue2 {
    //queue模式的消费者,一个消息只会被一个消费都消费
    @JmsListener(destination = "${spring.activemq.queue-name}")
    public void readActiveQueue(String message) {
        System.out.println("queue2接受到：" + message);
    }
}
