package com.worscipe.bright.common.auth;

import java.io.Serializable;

public class AuthResponse implements Serializable{
	
	private static final long serialVersionUID = 2600945695264239110L;
	
	private String jwt;
	
	public AuthResponse() {}
	
	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return jwt;
	}

}
