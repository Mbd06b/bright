package com.boot.brightideas.api;

import org.testng.annotations.DataProvider;

public class CommonDataProviders {
	
	@DataProvider
	public static Object [][] invalidCredentials(){
		return new Object [][] {
			{"let_me_in", ""},
			{"", "safest_password_in_the_world" },
			// etc 
		};
	}

}
