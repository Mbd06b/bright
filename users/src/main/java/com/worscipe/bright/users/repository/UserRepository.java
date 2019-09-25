package com.worscipe.bright.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//This is an HQL query
	@Query(value = "select u from User u where email = ?1")
	public Optional<User> findByEmail(final String email); 
	
}
