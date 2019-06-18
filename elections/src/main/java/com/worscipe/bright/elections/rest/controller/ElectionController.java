package com.worscipe.bright.elections.rest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.elections.model.ElectionType;
import com.worscipe.bright.elections.rest.manager.ElectionManager;
import com.worscipe.bright.elections.rest.view.ElectionView;
import com.worscipe.bright.elections.rest.view.RestResourceEntity;
import com.worscipe.bright.elections.rest.view.ResultPage;

@RestController
@RequestMapping(value = "/election",  produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ElectionController {
	
	private static final Logger logger = LogManager.getLogger(ElectionController.class); 
	
	private static final String DEFAULT_PAGE_INDEX = "1";
	private static final String DEFAULT_PAGE_SIZE_LIMIT = "20"; 
	
	
	@Autowired
	private ElectionManager electionManager;
	
	
	private Boolean electionTypeParamIsValid(String electionStr){	
		if(!ElectionType.isValid(electionStr)) {
		   logger.debug("invalid electionTypeParam=" + electionStr + " was not handled by controller, invalid enum String");
		   return false;
		}else {
			return true;
		}
	}
	
	
	
	// CRUD
	
	@GetMapping(value ="/")
	public ResponseEntity<List<ElectionView>> getAllElections(){
		return new ResponseEntity<List<ElectionView>>(electionManager.getAllElections(), HttpStatus.OK);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<ElectionView> getElection(@PathVariable final Long id){
		ElectionView electionView = electionManager.getElectionById(id);
		return new ResponseEntity<ElectionView>(electionView, HttpStatus.OK);
	}
	
	@GetMapping( value = "/getElectionsPagedByType.action")
	public ResponseEntity<ResultPage<ElectionView>> get(
			@RequestParam(value="page", defaultValue=DEFAULT_PAGE_INDEX) Integer pageNumber,
			@RequestParam(value="limit", defaultValue=DEFAULT_PAGE_SIZE_LIMIT) Integer limit,
			@RequestParam(value="electionType", defaultValue="") String electionType // Empty string == all elections)
	){
		
		if(!electionTypeParamIsValid(electionType)) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.debug("Finding elections by type, page=" + pageNumber.toString() + ", limit=" + limit.toString() + ", electionType=" + electionType);
		
		ResultPage<ElectionView> elections = this.electionManager.getElectionsPagedByType(electionType, pageNumber, limit);
		return new ResponseEntity<ResultPage<ElectionView>>(elections, HttpStatus.OK);
	}
	
	
	
	@PostMapping(value = "/")
	public ResponseEntity<ElectionView> createElection(String electionType, List<RestResourceEntity> entities){
		
		//Validate request
		if(entities.size() < 1) {
		   logger.debug("No entity provided to be an election candidate!");
		   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
		if(electionTypeParamIsValid(electionType)) {
		   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ElectionView election = electionManager.createElection(ElectionType.valueOf(electionType), entities); 
		
		return new ResponseEntity<>(election, HttpStatus.OK);
	  
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> deleteElection(@PathVariable final Long id){
		return new ResponseEntity<Boolean>(electionManager.deleteElection(id), HttpStatus.OK);
	}
	
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<ElectionView> updateElection(@PathVariable final Long id, @RequestBody ElectionView election){
		ElectionView updatedElection = electionManager.updateElection(id, election);
		return new ResponseEntity<ElectionView>(updatedElection, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/disable.action")
	public ResponseEntity<ElectionView> disableElection(@PathVariable final Long id){
		
		ElectionView disabledElection = electionManager.disableElection(id);
		
		if(disabledElection == null) {
			logger.error("disable.action for Election with id: " + id.toString() + ", returned null");
			   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ElectionView> (disabledElection, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/start.action")
	public ResponseEntity<ElectionView> startElection(@PathVariable final Long id){
		ElectionView startedElection = electionManager.startElection(id);
		
		if(startedElection == null) {
			logger.error("enable.action for Election with id: " + id.toString() + "returned null");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ElectionView>(startedElection, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/end.action")
	public ResponseEntity<ElectionView> endElection(@PathVariable final Long id){
	ElectionView endedElection = electionManager.endElection(id);
		
		if(endedElection == null) {
			logger.error("enable.action for Election with id: " + id.toString() + "returned null");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ElectionView>(endedElection, HttpStatus.OK);
	}
		 
	
}