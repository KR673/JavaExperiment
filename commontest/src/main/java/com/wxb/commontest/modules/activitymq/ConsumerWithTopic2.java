//package com.wxb.commontest.modules.activitymq;
//
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ConsumerWithTopic2 {
//
//    //topic模式的消费者
//    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener2")
//    public void readActiveQueue(String message) {
//        System.out.println("topic2接受到：" + message);
//    }
//}
