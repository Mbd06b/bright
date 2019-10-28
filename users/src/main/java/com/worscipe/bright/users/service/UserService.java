package com.worscipe.bright.users.service;

import java.util.List;
import java.util.Optional;

import com.worscipe.bright.users.model.User;

//https://www.journaldev.com/7655/spring-orm-example-jpa-hibernate-transaction

public interface UserService {
	
	Optional<User> findById(Long id);
	
	Optional<User> findByEmail(String email); 
	
	List<User> findAllUsers(); 
	
	User saveUser(User user); 
	
	Boolean existsByEmail(String email); 
	
	Boolean existsById(Long id);
		
	Boolean deleteUserById(Long id);

	// Idea Contributors
	List<User> findByIdea(Long ideaId);

	Boolean saveIdea(Long id, Long ideaId);

	Boolean deleteIdea(Long id, Long ideaId); 

}
