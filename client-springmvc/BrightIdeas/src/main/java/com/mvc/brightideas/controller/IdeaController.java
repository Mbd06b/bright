package com.mvc.brightideas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.brightideas.model.Idea;
import com.mvc.brightideas.restmanager.IdeaManager;
import com.mvc.brightideas.restmanager.UserManager;

@Controller
@RequestMapping("/idea")
public class IdeaController {
	
	@Autowired
	IdeaManager ideaManager; 
	
	@Autowired
	UserManager userManager;

	// ---------Retrieve All Ideas--------------
	@RequestMapping(value = "/ideas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Idea>> listAllIdeas() {

		List<Idea> ideas = ideaManager.getIdeas();
		if (ideas.isEmpty()) {
			return new ResponseEntity<List<Idea>>(HttpStatus.NO_CONTENT);
		}
		else {
		return new ResponseEntity<List<Idea>>(ideas, HttpStatus.OK);
		}
	}

	// --------------Retrieve Single Idea-----------

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Idea> getIdea(@PathVariable("id") Long id) {
		System.out.println("Fetching Idea with id" + id);
		
		
		Idea idea = ideaManager.getIdeaById(id);

		if (idea == null) {
			System.out.println("Idea with id: " + id + " not found ");
			return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
		}
		else { 
			return new ResponseEntity<Idea>(idea, HttpStatus.OK);
		}
	}

	// TODO Retrieve ideasByIdeaContributor() (value = "/Idea/{Ideaid} .. GET

	// --------Create an Idea-------
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Idea> createIdea(@RequestBody Idea idea) {
		System.out.println("Creating Idea: " + idea.getTitle());
		
		Idea newIdea = ideaManager.createIdea(idea);

		return new ResponseEntity<Idea>(newIdea, HttpStatus.CREATED);

	}	
	
	// -----Update an Idea ---------

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Idea> updateIdea(@RequestBody Idea idea) {

		Idea updatedIdea = ideaManager.updateIdea(idea);
		
		if (updatedIdea != null) {
			return new ResponseEntity<Idea>(updatedIdea, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Idea>(HttpStatus.BAD_REQUEST);	
		}

	}

	// --------Delete an Idea ---------
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Idea> deleteIdea(@PathVariable("id") Long id) {
		System.out.println("Fetching and Deleting Idea with id: " + id);

		if (ideaManager.deleteIdea(id)) {
			return new ResponseEntity<Idea>(HttpStatus.OK);
		}
		else {
		System.out.println("Unable to delete. Idea with id: " + id);
		return new ResponseEntity<Idea>(HttpStatus.BAD_REQUEST);
		}
	}

	
	
}
