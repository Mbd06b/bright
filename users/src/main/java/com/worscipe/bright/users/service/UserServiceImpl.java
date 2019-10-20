package com.worscipe.bright.users.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.model.User;
import com.worscipe.bright.users.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepository userRepository; 
	
	//used for setting a Mockito Repository for testing
	public void setUserRepository (UserRepository userRepository) {
		this.userRepository = userRepository; 
	}
	
	

	/**
	 *  saveUser() method also handles user Updates.
	 */
	
	@Override
	public User saveUser(User user) {
	 	return userRepository.save(user);
	}
	
	
	@Override
	public List<User> findAllUsers(){
		
		List<User> users = userRepository.findAll(); 
		
		return users; 
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		 Optional <User> user = userRepository.findByEmail(email); 
		 return (Boolean)user.isPresent();
	}
	
	@Override
	public Boolean existsById(Long id) {
		Optional <User> user = userRepository.findById(id); 
		 return (Boolean)user.isPresent();
	}


	@Override
	public User findById(final Long id) {
		
			   Optional <User> user = userRepository.findById(id);
			   
			   if(user.isPresent()) {
				   return user.get(); 
			   }
			   else {
			       return null;
			   }
		   
	}
	
	public User findByEmail(final String email) {
		
			Optional <User> user = userRepository.findByEmail(email);
			
		   if(user.isPresent()) {
			   return user.get(); 
		   } else {
		       return null;
		   }
		   
	}
	
	public Boolean deleteUser(User user) {
		if(existsById(user.getId())){
			userRepository.delete(user);
			return true;
		} else {
			return false;
		}
	}


	@Override
	public Boolean deleteUserById(Long id) {
		if(existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}



	@Override
	public List<User> findByIdea(Long ideaId) {
		Optional<List<User>> users = userRepository.findContributorsByIdea(ideaId);
		
		if(users.isPresent()) {
			return users.get();
		} else {
			return null; 
		} 
	}

}
