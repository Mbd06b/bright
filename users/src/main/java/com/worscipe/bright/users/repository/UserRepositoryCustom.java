package com.worscipe.bright.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.worscipe.bright.users.model.User;

public interface UserRepositoryCustom {
	
	@Query(value = "select u from User u where count")
	public Optional<List<User>> findContributorsByIdea(Long ideaId); 
	
}
