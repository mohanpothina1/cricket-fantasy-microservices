package com.team_builder_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.team_builder_service","model","service","controller","repository"})
@EnableMongoRepositories(basePackages = "repository")
public class TeamBuilderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamBuilderServiceApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
