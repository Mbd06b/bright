package com.worscipe.bright.common.auth;

import java.io.Serializable;

public class AuthRequest implements Serializable {
	
	
	private static final long serialVersionUID = 4591776533815994118L;
	
	private String key;
	private String password;
	
	public AuthRequest() {};
	
	public AuthRequest (String key, String password) {
		this.key = key;
		this.password = password;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
