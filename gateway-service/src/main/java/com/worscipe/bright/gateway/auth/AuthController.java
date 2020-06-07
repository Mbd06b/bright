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
@CrossOrigin(origins = "http://localhost:4200")
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
	@PostMapping(value = "/")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest requestToValidate){
	logger.debug("Gateway login() endpoint"); 
	Map<String, String> userClaims = userClient.loginUser(requestToValidate); 	
		if(Boolean.valueOf(userClaims.get("isAuthorized"))) {
			AuthResponse authenticatedResponse = new AuthResponse(tokenManager.generateToken(userClaims)); 
			return new ResponseEntity<>(authenticatedResponse, HttpStatus.OK);
		}

		return new ResponseEntity<>(new AuthResponse("false"), HttpStatus.UNAUTHORIZED); 
	}
	
	@PostMapping(value = "/token/subject")
	public ResponseEntity<?> getTokenSubject(@RequestBody String token) {
		if ( tokenManager.isValidToken(token) ) {
			String uid = tokenManager.decodeSubject(token);
			return new ResponseEntity<>(uid , HttpStatus.OK);
		}
		return new ResponseEntity<>("unauthorized", HttpStatus.OK);
	}
	
	@PostMapping(value = "/token")
	public ResponseEntity<Boolean> isTokenValid(@RequestBody String token){
		logger.debug("Gateway isTokenValid() endpoint");
	   Boolean isValid = tokenManager.isValidToken(token); 
	   logger.debug("isValid:{}",  isValid);
	   return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}
	
}