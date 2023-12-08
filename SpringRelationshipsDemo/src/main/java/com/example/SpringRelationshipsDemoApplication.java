package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.relationships.dao")
@EntityScan(basePackages = "com.example.relationships.entity")
//@ComponentScan(basePackages = "com.example.relationships")
public class SpringRelationshipsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRelationshipsDemoApplication.class, args);
	}
}
