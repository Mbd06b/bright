package com.worscipe.bright.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gateway-service")
public interface AuthClient {

	@PostMapping("auth/token/subject")
	String getTokenSubject(@RequestBody String token);
}

