package com.wxb.commontest.modules.activitymq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerWithQueue {
    //queue模式的消费者
    @JmsListener(destination = "${spring.activemq.queue-name}")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}
