package com.aztec.resourceclientservice.configs;

import com.aztec.constants.RabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class QueueBinding1 {

    @Bean
    public Queue queue1() {
        return QueueBuilder
                .durable(RabbitConstants.QUEUE_1)
                .build();
    }

    @Bean
    public Queue queueDLQ() {
        return QueueBuilder
                .durable(RabbitConstants.DL_QUEUE_1)
                .build();
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitConstants.EX_1);
    }

    @Bean
    public TopicExchange topicExchangeDL() {
        return new TopicExchange(RabbitConstants.DL_EX_1);
    }

    @Bean
    public Binding bindQueue1() {
        return BindingBuilder
                .bind(queue1())
                .to(topicExchange())
                .with(RabbitConstants.RK_1);
    }

    @Bean
    public Binding bindQueueDL() {
        return BindingBuilder
                .bind(queueDLQ())
                .to(topicExchangeDL())
                .with(RabbitConstants.DL_RK_1);
    }
}
