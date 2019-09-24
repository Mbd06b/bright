package com.worscipe.bright.users.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.users.manager.user.UserManager;
import com.worscipe.bright.users.modelview.user.UserView;

//Example   http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
//notes.. working from the design patterns when setting up the DAO and User Service, this tutorial was
//matching my use-case, with slight changes to the RequestMapping and method calls. 

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	
	 private static final Logger logger = LogManager.getLogger(UserRestController.class);


	@Autowired
	UserManager userManager;

	// --------------Retrieve All Users------------

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserView>> listAllUsers() {
		List<UserView> users = userManager.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserView>>(HttpStatus.OK);
		}
		for(UserView user : users) {
			logger.debug(user);
		}
		return new ResponseEntity<List<UserView>>(users, HttpStatus.OK);
	}

	// --------------Find User By Id----------

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

	// -------------Find User By Email ----------------
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> getUserByEmail(@PathVariable("email") String email) {
		logger.info("Looking for user with email: " + email);
		UserView user = userManager.findByEmail(email);

		if (user == null) {
			logger.debug("User with email: " + email + " not found ");
			return new ResponseEntity<UserView>(HttpStatus.NOT_FOUND);
		} else {
			logger.debug("User: " + user + " found! ");
			return new ResponseEntity<UserView>(user, HttpStatus.OK);
		}

	}
	
	// ----------- Check if User Exists (accepts id or email) ----------------
	@RequestMapping(value= "/exists/{identifier}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Boolean> userExists(@PathVariable("identifier") String identifier){
		
		Boolean exists = false; 
		boolean numeric = true; 
		Long id = 0L; 
		
		try {
			id = Long.parseLong(identifier);
		} catch (NumberFormatException e) {
			numeric = false;
		}
		
		if(numeric) {
			exists = userManager.existsById(id);
		} else {
			exists = userManager.existsByEmail(identifier);
		}		
		
		
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}
	

	// ---------Create a User -------------------

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> createUser(@RequestBody UserView user) {
		logger.info("Creating User: " + user.getEmail());

		if (userManager.existsByEmail(user.getEmail())) {
			logger.info("A User with email " + user.getEmail() + " already exists!");
			return new ResponseEntity<UserView>(HttpStatus.CONFLICT);
		}

		userManager.saveUser(user);

		return new ResponseEntity<UserView>(user, HttpStatus.CREATED);
	}

	// ----------Update a User ------------------------

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> updateUser(@RequestBody UserView updatedUser) {

		
		 UserView user = userManager.saveUser(updatedUser);
		 
		if (user != null) {
			return new ResponseEntity<UserView>(user, HttpStatus.OK);
		}

		logger.info("User with id " + updatedUser.getId() + " not found");
		return new ResponseEntity<UserView>(HttpStatus.BAD_REQUEST);

	}

	// ---------Delete a User -----------------------------

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserView> deleteUser(@PathVariable("id") Long id) {

		logger.info("Fetching and Deleting User with id: " + id);
		if (userManager.deleteUserById(id)) {
			return new ResponseEntity<UserView>(HttpStatus.OK);
		}
		logger.info("Unable to delete. User with id " + id);
		return new ResponseEntity<UserView>(HttpStatus.BAD_REQUEST);
	}

}
