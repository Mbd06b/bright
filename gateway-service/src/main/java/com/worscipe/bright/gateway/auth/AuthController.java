package com.worscipe.bright.gateway.auth;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class is providing Angular 5 endpoint
//JWT token. 
//https://dzone.com/articles/angular-5-material-design-login-application


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UserClient userClient; 

	@Autowired
	private TokenManager tokenManager;
	
	/**
	 * JWT token credential for application access. 
	 * @author matthew.b.dowell
	 * 
	 * @param loginToValidate
	 * 		
	 * @return ResponseEntity body with either a vaild jwt token string or rejection message.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest requestToValidate){
	logger.debug("Gateway login() endpoint"); 
	Map<Boolean, Role> userResponse = userClient.loginUser(requestToValidate); 	
	if(userResponse.containsKey(true)) {
		AuthResponse authenticatedResponse = new AuthResponse(tokenManager.generateToken(requestToValidate.getKey(), userResponse.get(true))); 
		return new ResponseEntity<>(authenticatedResponse, HttpStatus.OK);
	}
		
		// TODO
//		UserView existingUser = userClient.findByEmail(userToValidate.getEmail());
//		
//		if (existingUser == null) {
//			String message = ("User: " + userToValidate.getEmail() + " not found ");
//			logger.debug(message);
//			return new ResponseEntity<UserView>(userToValidate, HttpStatus.OK);
//		}
//		else if (Password.check(userToValidate.getPassword(), existingUser.getPassword())) {
//			 
//			 //passwords do match (success!).
//			 //authorized by attaching JWT token to userDTO for return to client
//			 UserView validUser = userClient.authorizeUser(existingUser);
//			 
//			return new ResponseEntity<UserView>(validUser, HttpStatus.OK);
//		}
//		else {
//			logger.debug("Passwords do not match");
//			return new ResponseEntity<UserView>(userToValidate, HttpStatus.OK);
//		}
		
		return new ResponseEntity<>(new AuthResponse("false"), HttpStatus.UNAUTHORIZED); 
		
	}
	
	@PostMapping(value = "/token")
	public ResponseEntity<Boolean> isTokenValid(@RequestBody String token){
		logger.debug("Gateway isTokenValid() endponit");
	   Boolean isValid = tokenManager.isValidToken(token); 
	   logger.debug("isValid:{}",  isValid);
	   return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}
	
}