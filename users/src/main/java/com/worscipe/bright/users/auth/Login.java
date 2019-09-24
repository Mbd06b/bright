package com.worscipe.bright.users.auth;

import java.io.Serializable;

public class Login implements Serializable {
	
	
	private static final long serialVersionUID = 4591776533815994118L;
	
	private String key;
	private String password;
	
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
