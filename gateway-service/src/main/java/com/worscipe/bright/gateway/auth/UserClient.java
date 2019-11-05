package com.worscipe.bright.gateway.auth;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "user-service")
public interface UserClient {

	
	// path: localhost:0000/user/login     Not sure about the return type here, but this how I'm thinking we'll request
	// to the user-service to authenticate an AuthRequest 
	@GetMapping("/login")
	Map<Boolean, Role> loginUser(AuthRequest authRequest); 
	
}
