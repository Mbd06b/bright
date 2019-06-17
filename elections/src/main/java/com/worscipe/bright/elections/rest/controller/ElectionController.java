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
import org.springframework.web.bind.annotation.RestController;

import com.worscipe.bright.elections.model.ElectionType;
import com.worscipe.bright.elections.rest.manager.ElectionManager;
import com.worscipe.bright.elections.rest.view.CandidateResourceEntity;
import com.worscipe.bright.elections.rest.view.ElectionView;

@RestController
@RequestMapping(value = "/election",  produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ElectionController {
	
	private static final Logger logger = LogManager.getLogger(ElectionController.class); 
	
	
	@Autowired
	private ElectionManager electionManager;
	
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
	
	
	@PostMapping(value = "/")
	public ResponseEntity<ElectionView> createElection(String electionType, List<CandidateResourceEntity> entities){
		
		//Validate request
		if(entities.size() < 1) {
		   logger.debug("No candidate ids provided");
		   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
		if(!ElectionType.isValid(electionType)) {
		   logger.debug("electionType was not handled by controller: electionType is["+electionType+"]");
		   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ElectionView election = electionManager.createElection(ElectionType.valueOf(electionType), entities); 
		
		return new ResponseEntity<>(election, HttpStatus.OK);
	  
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<ElectionView> updateElection(@PathVariable final Long id, @RequestBody ElectionView election){
		ElectionView updatedElection = electionManager.updateElection(id, election);
		return new ResponseEntity<ElectionView>(updatedElection, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> deleteElection(@PathVariable final Long id){
		return new ResponseEntity<Boolean>(electionManager.deleteElection(id), HttpStatus.OK);
	}
	
	
	
}
