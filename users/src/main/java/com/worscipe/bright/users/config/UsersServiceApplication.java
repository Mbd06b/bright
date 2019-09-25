package com.worscipe.bright.users.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.worscipe.bright.users.model" })
@ComponentScan({  "com.worscipe.bright.users"})
@EnableJpaRepositories(basePackages = { "com.worscipe.bright.users.repository" })
public class UsersServiceApplication {
	
	 private static final Logger LOGGER = LogManager.getLogger(UsersServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

}
