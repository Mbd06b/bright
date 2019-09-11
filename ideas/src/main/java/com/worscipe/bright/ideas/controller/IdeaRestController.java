package com.worscipe.bright.ideas.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.worscipe.bright.ideas.manager.idea.IdeaManager;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.modelview.idea.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;
import com.worscipe.bright.ideas.service.UserService;

//How to handle an Abstract endpoint in a RESTful controller
//Use a factory pattern in the service layer to handle the object
//https://stackoverflow.com/questions/50688285/inheritance-and-rest-api-controllers-dealing-with-subclasses

@RestController
@RequestMapping("/api/idea")
@CrossOrigin
public class IdeaRestController {
	
	private static final Logger logger = LogManager.getLogger(IdeaRestController.class);
	
	private static final String DEFAULT_PAGE_INDEX = "1";
	private static final String DEFAULT_PAGE_SIZE_LIMIT = "20";

	@Autowired
	IdeaManager ideaManager;

	@Autowired
	UserService userService;

	// ---------Retrieve All Ideas--------------
	/**
	 * Returns the ideaImpl views in JSON that can be served for rendering 
	 * @return All ideaImpl views
	 * 
	 */
	@GetMapping( value = "/ideas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<IdeaView>> listAllIdeas() {

		List<IdeaView> ideas = ideaManager.findAllIdeas();
		if (ideas.isEmpty()) {
			return new ResponseEntity<List<IdeaView>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<IdeaView>>(ideas, HttpStatus.OK);
	}
	
	/**
	 *  The main search method for returning ideas, searches for like query in; title subtitle, and story properties of Idea.
	 *  Returns a ResultPage object containing a list of results and additional information for front-end pagination.
	 * @param pageNumber
	 * @param limit
	 * @param searchText
	 * @return
	 */
	 // TODO Enhancements for Idea Searches.
	@GetMapping( value = "/getIdeasByQueryPageAndSize.action")
	public ResponseEntity<ResultPage<IdeaView>> getMessageKey(
		@RequestParam(value="page", defaultValue=DEFAULT_PAGE_INDEX) Integer pageNumber,
		@RequestParam(value="limit", defaultValue=DEFAULT_PAGE_SIZE_LIMIT) Integer limit,
		@RequestParam(value="searchQuery", defaultValue="") String searchText // empty query == all properties
	){
		logger.debug("Finding message properties with page=" + pageNumber.toString() + ", limit=" + limit.toString() + ", searchQuery=" + searchText);
		
		return new ResponseEntity<ResultPage<IdeaView>>(this.ideaManager.getIdeasPageByQueryPageAndSize(pageNumber, limit, searchText), HttpStatus.OK);
	}

	// --------------Retrieve Single IdeaImpl-----------

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeaView> getIdea(@PathVariable("id") Long id) {
		System.out.println("Fetching IdeaImpl with id" + id);
		
		
		IdeaView idea = ideaManager.findById(id);

		if (idea == null) {
			System.out.println("IdeaImpl with id: " + id + " not found ");
			return new ResponseEntity<IdeaView>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<IdeaView>(idea, HttpStatus.OK);

	}

	// TODO Retrieve ideasByIdeaContributor() (value = "/IdeaImpl/{Ideaid} .. GET

	// --------Create an IdeaImpl-------
	/**
	 * @param ideaImpl
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeaView> createIdea(@RequestBody IdeaView idea) {
		System.out.println("Creating IdeaImpl: " + idea.getTitle());
		
		ideaManager.saveIdea(idea);

		return new ResponseEntity<IdeaView>(idea, HttpStatus.CREATED);

	}	
	
	// -----Update an IdeaImpl ---------

	/**
	 * @param ideaImpl
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeaView> updateIdea(@RequestBody IdeaView idea) {
			
		Gson gson = new Gson();
		String json = gson.toJson(idea);
		
		System.out.println("ideadto: " + json); 
		
		IdeaView updatedIdea = ideaManager.saveIdea(idea);
		
		if (updatedIdea != null) {
			return new ResponseEntity<IdeaView>(updatedIdea, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<IdeaView>(HttpStatus.BAD_REQUEST);	
		}

	}

	// --------Delete an IdeaImpl ---------
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IdeaImpl> deleteIdea(@PathVariable("id") Long id) {
		System.out.println("Fetching and Deleting IdeaImpl with id: " + id);

		if (ideaManager.deleteById(id)) {
			return new ResponseEntity<IdeaImpl>(HttpStatus.OK);
		}
		System.out.println("Unable to delete. IdeaImpl with id " + id);
		return new ResponseEntity<IdeaImpl>(HttpStatus.BAD_REQUEST);
	}

}
