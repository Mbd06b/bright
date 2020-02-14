package com.worscipe.bright.users.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.model.UserRecord;
import com.worscipe.bright.users.modelview.UserView;
import com.worscipe.bright.users.service.UserService;

@RestController
@RequestMapping(value = "/{id}")
public class UserProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

	@Autowired
	private UserManager userManager; 
	
	@Autowired
	private UserService userService; 
	
	// --------------Get User By Id----------
	@GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> getUser(@PathVariable("id") Long id) {
		UserView user = userManager.findById(id);

		if (user == null) {
			logger.info("Requested user with id: {} not found ", String.valueOf(id));
			return new ResponseEntity<UserView>(HttpStatus.NO_CONTENT);
		}
		
			logger.debug("Getting User with id:{}", String.valueOf(id));
		return new ResponseEntity<UserView>(user, HttpStatus.OK);

	}
	
	// ---------Delete a User -----------------------------

		@DeleteMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<UserView> deleteUser(@PathVariable("id") Long id) {

			logger.info("Fetching and Deleting User with id: " + id);
			if (userManager.deleteUserById(id)) {
				return new ResponseEntity<UserView>(HttpStatus.OK);
			}
			logger.info("Unable to delete. User with id " + id);
			return new ResponseEntity<UserView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	
//--------- idea to user-------------------------------
	//    mapping user/{id}/idea/{ideaId}
		
		@GetMapping(value=" /idea/")
		public ResponseEntity<List<UserRecord>> getUserIdeasRef(@PathVariable("id") Long id){
			// TODO
			return null;
		}
		
		
		@GetMapping(value=" /idea/{ideaId} ")
		public ResponseEntity<UserRecord>getUserIdeaRef(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			// TODO
			return null; 
		}
					
		@PostMapping(value= "/idea/{ideaId}")
		public ResponseEntity<Boolean> saveIdea(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			
			if(userService.saveIdea(id, ideaId)) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@PutMapping(value= "/idea/{ideaId}")
		public ResponseEntity<Boolean> updateIdea(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			
			if(userService.saveIdea(id, ideaId)) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@DeleteMapping(value= "/idea/{ideaId}")
		public ResponseEntity<Boolean> deleteIdea(@PathVariable("id") Long id, @PathVariable("ideaId") Long ideaId){
			if(userService.deleteIdea(id, ideaId)) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		
		
	

}
