package com.emsi.microservice_commandes;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceCommandesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommandesApplication.class, args);
	}
}
