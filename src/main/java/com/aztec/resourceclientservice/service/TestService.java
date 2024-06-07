package com.aztec.resourceclientservice.service;


import com.aztec.constants.RabbitConstants;
import com.aztec.dto.RabbitDTO;
import com.aztec.object.QueueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private RabbitService rabbitService;

    public void sendMessageToQueue() {

        RabbitDTO rabbitDTO = RabbitDTO.builder()
                .id("1")
                .message("Test Message")
                .statusCode("0")
                .build();
        QueueConfig queueConfig = QueueConfig.builder()
                .exchangeName(RabbitConstants.EX_1)
                .routingKey(RabbitConstants.RK_1)
                .rabbitDTO(rabbitDTO)
                .build();
        rabbitService.sendMessage(queueConfig);
    }
}
