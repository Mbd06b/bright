package com.worscipe.bright.users.auth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;

//This class is providing Angular 5 endpoint
//JWT token. 
//https://dzone.com/articles/angular-5-material-design-login-application


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	private static final Logger logger = LogManager.getLogger(AuthController.class);


	@Autowired
	UserManager userManager; 

	@Autowired
	TokenManager tokenManager;
	
	/**
	 * JWT token credential for application access. 
	 * @author matthew.b.dowell
	 * 
	 * @param loginToValidate
	 * 		
	 * @return ResponseEntity body with either a vaild jwt token string or rejection message.
	 */
	
	@PostMapping(value = "/")
	public ResponseEntity<UserView> login(@RequestBody UserView userToValidate){
		
		UserView existingUser = userManager.findByEmail(userToValidate.getEmail());
		
		if (existingUser == null) {
			String message = ("User: " + userToValidate.getEmail() + " not found ");
			logger.debug(message);
			return new ResponseEntity<UserView>(userToValidate, HttpStatus.OK);
		}
		else if (Password.check(userToValidate.getPassword(), existingUser.getPassword())) {
			 
			 //passwords do match (success!).
			 //authorized by attaching JWT token to userDTO for return to client
			 UserView validUser = userManager.authorizeUser(existingUser);
			 
			return new ResponseEntity<UserView>(validUser, HttpStatus.OK);
		}
		else {
			logger.debug("Passwords do not match");
			return new ResponseEntity<UserView>(userToValidate, HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value = "/token")
	public ResponseEntity<Boolean> isTokenValid(@RequestBody String token){
		
	   Boolean isValid = tokenManager.isValidToken(token); 
	   logger.debug("isValid: " + isValid);
	   return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}
	
}