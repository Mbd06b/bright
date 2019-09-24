package com.worscipe.bright.users.auth;

import com.worscipe.bright.users.modelview.user.UserView;

// creating JWTtokens https://www.baeldung.com/java-json-web-tokens-jjwt

public interface TokenManager {

	public String generateFakeToken(String email);

	public String generateToken(UserView user);
	
	public Boolean isValidToken(String token);

}
