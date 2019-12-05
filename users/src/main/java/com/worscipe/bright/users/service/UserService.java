package com.worscipe.bright.users.service;

import java.util.List;

import com.worscipe.bright.users.model.UserImpl;

//https://www.journaldev.com/7655/spring-orm-example-jpa-hibernate-transaction

public interface UserService {
	
	UserImpl findById(Long id);
	
	UserImpl findByEmail(String email); 
	
	List<UserImpl> findAllUsers(); 
	
	UserImpl saveUser(UserImpl userImpl); 
	
	Boolean existsByEmail(String email); 
	
	Boolean existsById(Long id);
		
	Boolean deleteUserById(Long id);

	// Idea Contributors
	List<UserImpl> findByIdea(Long ideaId);

	Boolean saveIdea(Long id, Long ideaId);

	Boolean deleteIdea(Long id, Long ideaId);

}
