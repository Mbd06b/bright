package com.worscipe.bright.users.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worscipe.bright.users.client.IdeaClient;
import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;
import com.worscipe.bright.users.service.UserService;

@RequestMapping(value = "/{id}")
public class UserProfileController {
	
	private static final Logger logger = LogManager.getLogger(UserProfileController.class);

	@Autowired
	private UserManager userManager; 
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private IdeaClient ideaClient; 
	
	
	// --------------Get User By Id----------

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> getUser(@PathVariable("id") Long id) {
		logger.info("Fetching User with id" + id);
		UserView user = userManager.findById(id);

		if (user == null) {
			logger.info("Requested user with id: " + id + " not found ");
			return new ResponseEntity<UserView>(HttpStatus.NO_CONTENT);
		}
		
			logger.debug(user);
		return new ResponseEntity<UserView>(user, HttpStatus.OK);

	}
	
	// ---------Delete a User -----------------------------

		@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<UserView> deleteUser(@PathVariable("id") Long id) {

			logger.info("Fetching and Deleting User with id: " + id);
			if (userManager.deleteUserById(id)) {
				return new ResponseEntity<UserView>(HttpStatus.OK);
			}
			logger.info("Unable to delete. User with id " + id);
			return new ResponseEntity<UserView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	
	//---------Save idea to user-------------------------------
	//   POST  mapping user/{id}/idea/{ideaId}
					
		@PutMapping(value= "/idea/{ideaId}")
		public ResponseEntity<?> saveIdea(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			
			if(userService.saveIdea(id, ideaId)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@DeleteMapping(value= "/idea/{ideaId}")
		public ResponseEntity<?> deleteIdea(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			if(userService.deleteIdea(id, ideaId)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		
		
	

}
