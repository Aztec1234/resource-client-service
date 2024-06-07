package com.aztec.resourceclientservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private RabbitService rabbitService;

    public void printProps() {
        rabbitService.sendMessage("Hello from  resource server 1 !");
    }
}
