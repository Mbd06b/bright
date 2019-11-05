package com.worscipe.bright.gateway.auth;


// creating JWTtokens https://www.baeldung.com/java-json-web-tokens-jjwt

public interface TokenManager {

	public String generateFakeToken(String email);

	public String generateToken(String key, Role role); 
	
	public Boolean isValidToken(String token);

}
