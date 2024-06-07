package com.aztec.resourceclientservice.controller;

import com.aztec.resourceclientservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String testController(){
        System.out.println("Hello from Resource Server");
        testService.sendMessageToQueue();
        return "Hello from Resource Server 1";
    }
}
