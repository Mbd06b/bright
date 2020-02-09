package com.worscipe.bright.ideas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients(basePackages =  {"com.worscipe.bright.ideas.client"})
@EntityScan(basePackages = { "com.worscipe.bright.ideas.model" })
@ComponentScan({  "com.worscipe.bright.ideas"})
@EnableJpaRepositories(basePackages = { "com.worscipe.bright.ideas.repository" })
public class IdeaServiceApplication {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(IdeaServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IdeaServiceApplication.class, args);
	}

}
