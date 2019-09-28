package com.worscipe.bright.ideas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "election-service")
public interface ElectionClient {

	@GetMapping("idea/{ideaId}/elections")
	List<Long> findElectionsById(@PathVariable("ideaId") Long ideaId);
}
