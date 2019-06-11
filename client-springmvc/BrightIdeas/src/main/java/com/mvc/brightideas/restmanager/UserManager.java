package com.mvc.brightideas.restmanager;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.brightideas.model.Password;
import com.mvc.brightideas.model.User;


//Writing REST Client using RestTemplate  - http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
//RestTemplate API guide - https://www.baeldung.com/rest-template
// Writing RestTemplate with Response Entity wrappers - https://www.baeldung.com/spring-rest-template-list

// xxForObject -> Java Object
// xxForLocation

@Service
public class UserManager {

	private static final String userApiUrl = "http://localhost:7000/api/user/"; 
	
	@Autowired
	private final RestTemplate restTemplate; 
	
	public UserManager(RestTemplate restTemplate) {
		this.restTemplate = restTemplate; 
	}

	public List<User> getUsers() {

		ResponseEntity<List<User>> response = restTemplate.exchange(userApiUrl + "users", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});

		List<User> users = response.getBody();

		return users;
	}

	
	public User getUserById(Long id) {
		return this.restTemplate.getForObject(userApiUrl + "{id}", User.class);
	}
	
	public User findByEmail(String email) {
		return restTemplate.getForObject(userApiUrl + "email/{email}", User.class, email);
	}
	
	
	  /* POST */
    public User createUser(User user) {
    	user.setPassword(Password.hash(user.getPassword()));
        return restTemplate.postForObject(userApiUrl, user, User.class);
    }
    
    
    
    //TODO how to check return type? as restTemplate.put() returns void. 
    /* PUT */ 
    public User updateUser(User user) {
    	System.out.println("restTemplate.put(..) request for User Id: " + user.getId());
    	
    	//returns void
        restTemplate.put(userApiUrl, user, User.class);
        
        return getUserById(user.getId());
    }
    
    
    /* DELETE */
    public Boolean deleteUser(Long id) {
    	System.out.println("User with Id: " + id);
    	
    	restTemplate.delete(userApiUrl + id);
    	
    	User user = getUserById(id); 
    	if(user == null) {
    		//delete successful
    		return true; 
    	}
    	else {
    		System.out.println("restTemplate.delete(), getUserById(id) returned something not null??" + user);
    		return false; 
    	}
    }
	

	
	
	
}


