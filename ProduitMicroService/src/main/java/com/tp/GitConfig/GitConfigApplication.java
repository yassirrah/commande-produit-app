package com.tp.GitConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class GitConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitConfigApplication.class, args);
	}

}
