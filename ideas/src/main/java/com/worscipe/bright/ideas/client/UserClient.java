package com.worscipe.bright.ideas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("/idea/{ideaId}")
	List<Long> findByIdea(@PathVariable("ideaId") Long ideaId);
	
}
