package com.aztec.resourceclientservice.listener;

import com.aztec.dto.RabbitDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @RabbitListener(queues = "q.queue2")
    public void receiveMessage(RabbitDTO rabbitDTO) {
        System.out.println("Message received: " + rabbitDTO.getMessage());
    }
}
