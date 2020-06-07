package com.worscipe.bright.gateway.auth;

import java.util.Map;

// creating JWTtokens https://www.baeldung.com/java-json-web-tokens-jjwt

public interface TokenManager {

	 String generateToken(Map<String,String> claims); 
	
	 Boolean isValidToken(String token);
	
	 String decodeSubject(String token);

}
