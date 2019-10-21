package com.worscipe.bright.users.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;

@RestController
public class ContributorController {
	
	private static final Logger LOGGER = LogManager.getLogger(ContributorController.class);

	
	@Autowired
	private UserManager userManager;
	
	
	@GetMapping("/idea/{ideaId}")
	public ResponseEntity<List<UserView>> findContributorsByIdeaId(@PathVariable("ideaId") Long ideaId) {
		LOGGER.info("User(Contributor) find: ideaId={}", ideaId);
		List<UserView> foundUsers = userManager.findContributorsByIdeaId(ideaId);
		return new ResponseEntity<List<UserView>>(foundUsers, HttpStatus.OK);
	}
	

}
