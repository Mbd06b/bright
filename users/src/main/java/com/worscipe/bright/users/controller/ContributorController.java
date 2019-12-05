package com.worscipe.bright.users.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;
import com.worscipe.bright.users.service.RecordService;

@RestController
public class ContributorController {
	
	private static final Logger logger = LogManager.getLogger(ContributorController.class);
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RecordService recordService; 
	
	@GetMapping("/idea/{ideaId}")
	public ResponseEntity<List<UserView>> findContributorsByIdeaId(@PathVariable("ideaId") Long ideaId) {
		logger.info("User(Contributor) find: ideaId={}", ideaId);
		List<UserView> foundUsers = userManager.findContributorsByIdeaId(ideaId);
		
		if( foundUsers.isEmpty()) {
			return new ResponseEntity<List<UserView>>(HttpStatus.NO_CONTENT); 
		} else {
			
			return new ResponseEntity<List<UserView>>(foundUsers, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/purge/idea/{ideaId}")
	public ResponseEntity<Boolean> purgeIdeaRecords(@PathVariable("ideaId") Long ideaId){
		logger.info("Purging idea ID: {ideaId} from all users");
		
		if(recordService.purgeIdea(ideaId)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
		
		
	}
	
	
	
	
	
	
}
