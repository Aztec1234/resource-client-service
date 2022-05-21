package com.aztec.resourceclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ResourceClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceClientServiceApplication.class, args);
	}

}
