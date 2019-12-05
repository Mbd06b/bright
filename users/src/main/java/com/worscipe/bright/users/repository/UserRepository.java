package com.worscipe.bright.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.users.model.UserImpl;

@Repository
public interface UserRepository extends JpaRepository<UserImpl, Long>, UserRepositoryCustom {
	
	//This is an HQL query
	@Query(value = "select u from UserImpl u where email = ?1")
	public Optional<UserImpl> findByEmail(final String email);

	
}
