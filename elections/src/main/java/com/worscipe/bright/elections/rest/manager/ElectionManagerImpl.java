package com.worscipe.bright.elections.rest.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.elections.model.CandidateImpl;
import com.worscipe.bright.elections.model.Election;
import com.worscipe.bright.elections.model.rcv.RCVElectionImpl;
import com.worscipe.bright.elections.rest.view.ElectionView;
import com.worscipe.bright.elections.rest.view.RestResourceEntity;
import com.worscipe.bright.elections.rest.view.ResultPage;
import com.worscipe.bright.elections.service.ElectionService;
import com.worscipe.bright.elections.service.RCVElectionService;

@Service
public class ElectionManagerImpl implements ElectionManager {
	
	private static final Logger logger = LogManager.getLogger(ElectionManagerImpl.class);
	
	@Autowired
	private ElectionService electionService;
	
	@Autowired
	private RCVElectionService rcvElectionService;
	
	
	private ElectionView copyToView(Election electionImpl) {
		ElectionView view = new ElectionView();
		// TODO convert;
		return view;
	}
	
	@Override
	public ElectionView createElection(String electionType, List<RestResourceEntity> entities) {
		
		Set<CandidateImpl> candidates = new HashSet<>();
		   
		   for(RestResourceEntity e : entities) {
			  candidates.add(new CandidateImpl(e));
		   }
		   
			
		switch (electionType) {
			case "UP_VOTE":
					return null;
			case "REACTION_VOTE":
					return null;
			case "UP_DOWN_VOTE":
					return null;
			case "SINGLE_TRANSFERABLE_VOTE":
					RCVElectionImpl election = new RCVElectionImpl();
				 	election.setCandidates(candidates);
					RCVElectionImpl electionImpl = rcvElectionService.createElection(election);
					ElectionView electionView = copyToView(electionImpl);
					return electionView;
			default: 
				logger.error("ElectionType: [" + electionType + "] did not match any cases");
				break;
		}
		
		//Long electionId = electionService.saveElection()
		return null;
	}


	@Override
	public List<ElectionView> getAllElections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionView getElectionById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionView updateElection(Long id, ElectionView election) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteElection(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultPage<ElectionView> getElectionsPagedByType(String electionType, Integer pageNumber, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionView disableElection(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionView startElection(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectionView endElection(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidType(String electionType) {
		// TODO Auto-generated method stub
		return false;
	}



}
