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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.common.auth.AuthRequest;
import com.worscipe.bright.common.auth.Password;
import com.worscipe.bright.users.client.AuthClient;
import com.worscipe.bright.users.manager.UserManager;
import com.worscipe.bright.users.modelview.UserView;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserManager userManager;
	
	@Autowired 
	private AuthClient authClient;
	
	@PostMapping(value = "/")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
		logger.debug("user login()");
		UserView existingUser = userManager.findByEmail(authRequest.getKey());

		if (existingUser == null) {
			logger.debug("User: {} not found", authRequest.getKey());
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else if (Password.check(authRequest.getPassword(), existingUser.getPassword())) {

			// passwords do match (success!) add claims for jwt
			Map<String, String> validatedResult = new HashMap<>();
			validatedResult.put("isAuthorized", "true");
			validatedResult.put("role", existingUser.getRole().name());
			validatedResult.put("uid", existingUser.getId().toString());
			return new ResponseEntity<>(validatedResult, HttpStatus.OK);
		} else {
			logger.debug("Passwords do not match");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}

	}
	
	@PostMapping(value = "/token")
	public ResponseEntity<?> tokenLogin(@RequestBody String token) {
		logger.debug("user token()");
		Long uid = Long.valueOf(authClient.getTokenSubject(token));
		if (uid == null) {
			return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(userManager.findById(uid), HttpStatus.OK);
	}
	
	 
	/**
	 *  -------------Get User By Key ----------------
	 * @param key , key is email address
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> getUserByEmail(@RequestBody AuthRequest key) {
		logger.info("Looking for user with key:{} ", key);
		UserView user = userManager.findById(Long.valueOf(key.getKey()));
		
		if (user == null) {
			logger.debug("User with id: {} not found ", key);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Subject subject = new Subject();
			subject.setId(user.getId());
			subject.setRole(user.getRole());
			logger.debug("User: {} found! ", user);
			return new ResponseEntity<>(subject, HttpStatus.OK);
		}
	}
	
}
