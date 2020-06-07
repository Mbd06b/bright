package com.worscipe.bright.gateway.auth;

import java.util.Map;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "user-service")
public interface UserClient {

	// to the user-service to authenticate an AuthRequest 
	@PostMapping("/login/")
	Map<String, String> loginUser(AuthRequest authRequest); 
	
	@PostMapping("/login/user")
	Subject getUserByKey(AuthRequest authRequest);
	
	
}
