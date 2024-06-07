package com.aztec.resourceclientservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @RabbitListener(queues = "q.queue2")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
