package com.aztec.resourceclientservice.service;


import com.aztec.dto.RabbitDTO;
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
        rabbitService.sendMessage(rabbitDTO);
    }
}
