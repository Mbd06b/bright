package com.worscipe.bright.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = { "com.worscipe.bright.gateway" })
@ComponentScan({  "com.worscipe.bright.gateway"})
@EnableFeignClients
public class GatewayApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
}
