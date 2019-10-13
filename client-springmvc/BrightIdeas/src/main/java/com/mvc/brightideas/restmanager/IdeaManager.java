package com.mvc.brightideas.restmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.brightideas.model.Idea;

@Service
public class IdeaManager {
	
	private static final String ideaApiUrl = "http://localhost:6160//idea/"; 
	
	@Autowired
	private final RestTemplate restTemplate; 
	
	public IdeaManager(RestTemplate restTemplate) {
		this.restTemplate = restTemplate; 
	}
	
	
	public List<Idea> getIdeas(){
		ResponseEntity<List<Idea>> response = restTemplate.exchange(ideaApiUrl + "ideas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Idea>>() {});
	
		List<Idea> ideas = response.getBody(); 
		return ideas; 
	}
	
	
	/* GET */
	public Idea getIdeaById(Long id) {
		return restTemplate.getForObject(ideaApiUrl + "{id}", Idea.class);
		
	}
	
	/* POST */
    public Idea createIdea(Idea idea) {
       return restTemplate.postForObject(ideaApiUrl, idea, Idea.class);
    }
    
    
    /* PUT */
    public Idea updateIdea(Idea idea) {
    	System.out.println("restTemplate.put(...> request for (idea): " + idea.getTitle());
    	
    	//returns void
    	restTemplate.put(ideaApiUrl,  idea, Idea.class);
    	
    	return getIdeaById(idea.getId());
    }
    
    
    
    
    /* DELETE */
    public Boolean deleteIdea(Long id) {
    	System.out.println("restTemplate.delete() Idea with Id: " + id); 
    	
    	restTemplate.delete(ideaApiUrl + "{id}");
    	
    	Idea idea = getIdeaById(id);
    	
    	if(idea == null) {
    		//delete successful
    		return true; 
    	}
    	else {
    		System.out.println("restTemplate.delete(), getIdeaById(id) returned something not null??" + idea);
    		return false; 
    	}
    	
    }
	
	
	
	

}
