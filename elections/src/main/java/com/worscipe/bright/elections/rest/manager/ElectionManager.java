package com.worscipe.bright.elections.rest.manager;

import java.util.List;

import com.worscipe.bright.elections.model.ElectionType;
import com.worscipe.bright.elections.rest.view.CandidateResourceEntity;
import com.worscipe.bright.elections.rest.view.ElectionView;

public interface ElectionManager {
			
		public List<ElectionView> getAllElections();
		
	    public ElectionView getElectionById(Long id);
	    
	    public ElectionView updateElection(Long id, ElectionView election);
	    
	    public Boolean deleteElection(Long id);

		ElectionView createElection(ElectionType electionType, List<CandidateResourceEntity> entities);	    
	    
			
}
