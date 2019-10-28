package com.worscipe.bright.users.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "idea-service")
public interface IdeaClient {
	
	
	@GetMapping("/idea/{ideaId}")
	List<Long> findByIdea(@PathVariable("ideaId") Long ideaId);
	

	
	
}
