package com.worscipe.bright.ideas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "user-service")
public interface UserClient {

	// remember the context here is in the idea service
	// mappings are all prefixed with "user/" (Ex: ${gatewayURL}/idea/{ideaId}/users  is findByIdea
	
	@GetMapping("{ideaId}/users")
	List<Long> findByIdea(@PathVariable("ideaId") Long ideaId);
	
	@PostMapping("{ideaId}/user")
	Boolean updateContributor(@PathVariable("ideaId") Long ideaId);
	
	@PostMapping("/{userId}/idea/{ideaId}")
	Boolean updateUserRecord(@PathVariable("ideaId") Long userId, @PathVariable("userId") Long ideaId);
	
	@DeleteMapping("/{userId}/idea/{ideaId}")
	Boolean deleteUserIdeaRecord(@PathVariable("userId") Long userId, @PathVariable("ideaId") Long ideaId);
	
	@DeleteMapping("/purge/idea/{ideaId}")
	Boolean purgeUserIdeaRecords(@PathVariable("ideaId")Long id);
	
}
