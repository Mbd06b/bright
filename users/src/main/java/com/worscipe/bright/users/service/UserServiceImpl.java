package com.worscipe.bright.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.model.UserImpl;
import com.worscipe.bright.users.model.UserRecord;
import com.worscipe.bright.users.repository.UserRepository;

@Service
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
	public UserImpl saveUser(UserImpl userImpl) {
	 	return userRepository.save(userImpl);
	}
	
	@Override
	public List<UserImpl> findAllUsers(){
		
		List<UserImpl> userImpls = userRepository.findAll(); 
		
		return userImpls; 
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		 Optional <UserImpl> userImpl = userRepository.findByEmail(email); 
		 return (Boolean)userImpl.isPresent();
	}
	
	
	@Override
	public Boolean existsById(Long id) {
		Optional <UserImpl> userImpl = userRepository.findById(id); 
		 return userImpl.isPresent();
	}


	@Override
	public UserImpl findById(final Long id) {
		Optional<UserImpl> userImpl	= userRepository.findById(id);
		if(userImpl.isPresent()) {
			return userImpl.get();
		} else {
			return new UserImpl(); 
		}
	}
	
	public UserImpl findByEmail(final String email) {
		Optional<UserImpl> userImpl = userRepository.findByEmail(email);
		if(userImpl.isPresent()) {
			return userImpl.get();
		} else {
			return new UserImpl(); 
		}
	}
	
	public Boolean deleteUser(UserImpl userImpl) {
		if(existsById(userImpl.getId())){
			userRepository.delete(userImpl);
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
	public List<UserImpl> findByIdea(Long ideaId) {
	
		UserImpl u = new UserImpl();
		UserRecord r = new UserRecord(); 
		r.setEntityId(ideaId);
		
		Set<UserRecord> c = new HashSet<UserRecord>();
		c.add(r);
		 u.setIdeas(c);
		 
		Example<UserImpl> example = Example.of(u);
		Optional<List<UserImpl>> userImpls = Optional.of(userRepository.findAll(example));
		
		if(userImpls.isPresent()) {
			return userImpls.get();
		} else {
			return new ArrayList<>(); 
		} 
	}
	
	@Override
	public Boolean saveIdea(Long id, Long ideaId) {
		 Optional<UserImpl> userImpl = userRepository.findById(id); 
		 if(userImpl.isPresent()) {
			userImpl.get().addIdea(new UserRecord(ideaId));
			 saveUser(userImpl.get());
			 return true; 
		 } else {
			return false;
		 }
	}


	@Override
	public Boolean deleteIdea(Long id, Long ideaId) {
		 Optional<UserImpl> userImpl = userRepository.findById(id); 
		 if(userImpl.isPresent()) {
			userImpl.get().getIdeas().removeIf(n -> ideaId.equals(n.getEntityId()));
			 saveUser(userImpl.get());
			 return true; 
		 } else {
			return false;
		 }
	}

}
