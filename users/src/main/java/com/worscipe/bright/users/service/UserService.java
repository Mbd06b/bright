package com.worscipe.bright.users.service;

import java.util.List;

import com.worscipe.bright.users.model.User;

//https://www.journaldev.com/7655/spring-orm-example-jpa-hibernate-transaction

public interface UserService {
	
	User findById(Long id);
	
	User findByEmail(String email); 
	
	List<User> findAllUsers(); 
	
	User saveUser(User user); 
	
	Boolean existsByEmail(String email); 
	
	Boolean existsById(Long id);
		
	Boolean deleteUserById(Long id); 
	
	

}
