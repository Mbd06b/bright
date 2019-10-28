package com.worscipe.bright.users.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.model.User;
import com.worscipe.bright.users.model.UserRecord;
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
		 return user.isPresent();
	}


	@Override
	public Optional<User> findById(final Long id) {
		return userRepository.findById(id);	   
	}
	
	public Optional<User> findByEmail(final String email) {
		return userRepository.findByEmail(email);
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
	
		User u = new User();
		UserRecord r = new UserRecord(); 
		r.setEntityId(ideaId);
		
		Set<UserRecord> c = new HashSet<UserRecord>();
		c.add(r);
		 u.setIdeas(c);
		 
		Example<User> example = Example.of(u);
		Optional<List<User>> users = Optional.of(userRepository.findAll(example));
		
		if(users.isPresent()) {
			return users.get();
		} else {
			return null; 
		} 
	}
	
	@Override
	public Boolean saveIdea(Long id, Long ideaId) {
		 Optional<User> user = findById(id); 
		 if(user.isPresent()) {
			user.get().getIdeas().add(new UserRecord(ideaId));
			 saveUser(user.get());
			 return true; 
		 } else {
			return false;
		 }
	}


	@Override
	public Boolean deleteIdea(Long id, Long ideaId) {
		 Optional<User> user = findById(id); 
		 
		 if(user.isPresent()) {
			user.get().getIdeas().removeIf(n -> n.getEntityId() == ideaId);
			 saveUser(user.get());
			 return true; 
		 } else {
			return false;
		 }
	}

}
