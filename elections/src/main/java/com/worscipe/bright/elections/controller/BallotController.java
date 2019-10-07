package com.worscipe.bright.elections.controller;

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

import com.worscipe.bright.elections.manager.BallotManager;
import com.worscipe.bright.elections.model.Ballot;
import com.worscipe.bright.elections.view.BallotView;
import com.worscipe.bright.elections.view.ResultPage;

@RestController
@RequestMapping(value = "/election/{electionId}/ballot",  produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BallotController {
	
	private static final Logger logger = LogManager.getLogger(BallotController.class); 
	
	private static final String DEFAULT_PAGE_INDEX = "1";
	private static final String DEFAULT_PAGE_SIZE_LIMIT = "20"; 
		
		@Autowired
		private BallotManager ballotManager; 	
	
	
		@GetMapping(value ="/")
		public ResponseEntity<List<BallotView>> getAllBallots(@RequestParam("electionId") final Long electionId){
			return new ResponseEntity<List<BallotView>>(ballotManager.getAllBallots(electionId), HttpStatus.OK);
		}
		
		@GetMapping(value= "/{id}")
		public ResponseEntity<BallotView> getElection(@PathVariable("electionId") final Long electionId, @PathVariable final Long id){
			BallotView electionView = ballotManager.getBallotById(electionId, id);
			return new ResponseEntity<BallotView>(electionView, HttpStatus.OK);
		}
		
		@GetMapping( value = "/getBallotsPagedByType.action")
		public ResponseEntity<ResultPage<BallotView>> get(
				@PathVariable("electionId") final Long electionId,
				@RequestParam(value="page", defaultValue=DEFAULT_PAGE_INDEX) Integer pageNumber,
				@RequestParam(value="limit", defaultValue=DEFAULT_PAGE_SIZE_LIMIT) Integer limit,
				@RequestParam(value="candidateId", defaultValue="") String candidateId // Empty string == all elections)
		){
						
			logger.debug("Finding ballots by candidate, page=" + pageNumber.toString() + ", limit=" + limit.toString() + ", electionType=" + candidateId);
			
			ResultPage<BallotView> ballotPage = this.ballotManager.getBallotsPagedByCandidate(candidateId, pageNumber, limit);
			return new ResponseEntity<ResultPage<BallotView>>(ballotPage, HttpStatus.OK);
		}
		
		
		
		@PostMapping(value = "/")
		public ResponseEntity<BallotView> castBallot( @PathVariable("electionId") final Long electionId, 
				String electionType, Ballot ballot){
				
		
			BallotView ballotCast = ballotManager.castBallot(electionId, ballot); 
			
			return new ResponseEntity<>(ballotCast, HttpStatus.OK);
		  
		}
		
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Boolean> deleteBallot(@PathVariable("electionId") final Long electionId, @PathVariable final Long id){
			return new ResponseEntity<Boolean>(ballotManager.deleteBallot(electionId, id), HttpStatus.OK);
		}
		
		
		@PutMapping(value ="/{id}")
		public ResponseEntity<BallotView> updateElection(@PathVariable("electionId") final Long electionId, @PathVariable final Long id, @RequestBody Ballot ballot){
			BallotView updatedBallot = ballotManager.updateBallot(id, ballot);
			return new ResponseEntity<BallotView>(updatedBallot, HttpStatus.OK);
		}
		

}
