package com.worscipe.bright.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.common.auth.AuthRequest;
import com.worscipe.bright.common.auth.Role;
import com.worscipe.bright.common.auth.Password;
import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserManager userManager;
	
	
	@PostMapping(value = "/")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
		logger.debug("user login()"); 
	UserView existingUser = userManager.findByEmail(authRequest.getKey());
		
		if (existingUser == null) {
			logger.debug("User: {} not found", authRequest.getKey());
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else if (Password.check(authRequest.getPassword(), existingUser.getPassword())) {
			 
			 //passwords do match (success!)			 
			 Map<Boolean, Role> validatedResult = new HashMap<>();
			 validatedResult.put(Boolean.valueOf(true), existingUser.getRole());
			return new ResponseEntity<>(validatedResult, HttpStatus.OK);
		}
		else {
			logger.debug("Passwords do not match");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		
	}

}
