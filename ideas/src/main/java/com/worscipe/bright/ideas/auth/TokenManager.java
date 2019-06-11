package com.worscipe.bright.ideas.auth;

import com.worscipe.bright.ideas.modelview.user.UserView;

// creating JWTtokens https://www.baeldung.com/java-json-web-tokens-jjwt

public interface TokenManager {

	public String generateFakeToken(String email);

	public String generateToken(UserView user);
	
	public Boolean isValidToken(String token);

}
