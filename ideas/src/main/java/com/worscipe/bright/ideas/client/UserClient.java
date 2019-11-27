package com.worscipe.bright.ideas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "user-service")
public interface UserClient {

	// remember the context here is in the idea service
	// mappings are all prefixed with "idea/" (Ex: ${gatewayURL}/idea/{ideaId}/users  is findByIdea
	
	@GetMapping("{ideaId}/users")
	List<Long> findByIdea(@PathVariable("ideaId") Long ideaId);
	
	@PostMapping("{ideaId}/user")
	Boolean updateContributor(@PathVariable("ideaId") Long ideaId);
	
	@PostMapping("/{ideaId}/user/{userId}")
	Boolean updateUserRecord(@PathVariable("ideaId") Long ideaId, Long userId);
	
}
