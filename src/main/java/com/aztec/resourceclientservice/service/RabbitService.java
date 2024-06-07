package com.aztec.resourceclientservice.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue1() {
        return new Queue("q.queue1", false);
    }

    @Bean
    public Queue queue2() {
        return new Queue("q.queue2", false);
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("q.queue1", message);
        System.out.println("Message sent: " + message);
    }

}
