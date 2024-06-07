package com.aztec.resourceclientservice.configs;

import com.aztec.constants.RabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class QueueBinding2 {

    @Bean
    public Queue queue2() {
        return QueueBuilder
                .durable(RabbitConstants.QUEUE_2)
                .build();
    }

    @Bean
    public Queue queueDLQ2() {
        return QueueBuilder
                .durable(RabbitConstants.DL_QUEUE_2)
                .build();
    }

    @Bean
    public TopicExchange topicExchange2() {
        return new TopicExchange(RabbitConstants.EX_2);
    }

    @Bean
    public TopicExchange topicExchangeDL2() {
        return new TopicExchange(RabbitConstants.DL_EX_2);
    }

    @Bean
    public Binding bindQueue2() {
        return BindingBuilder
                .bind(queue2())
                .to(topicExchange2())
                .with(RabbitConstants.RK_2);
    }

    @Bean
    public Binding bindQueueDL2() {
        return BindingBuilder
                .bind(queueDLQ2())
                .to(topicExchangeDL2())
                .with(RabbitConstants.DL_RK_2);
    }
}
