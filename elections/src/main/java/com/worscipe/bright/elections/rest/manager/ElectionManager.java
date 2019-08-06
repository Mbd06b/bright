package com.worscipe.bright.elections.rest.manager;

import java.util.List;

import com.worscipe.bright.elections.model.ElectionType;
import com.worscipe.bright.elections.rest.view.BallotView;
import com.worscipe.bright.elections.rest.view.ElectionView;
import com.worscipe.bright.elections.rest.view.RestResourceEntity;
import com.worscipe.bright.elections.rest.view.ResultPage;

public interface ElectionManager {
			
		public List<ElectionView> getAllElections();
		
	    public ElectionView getElectionById(Long id);
	    
	    public ElectionView updateElection(Long id, ElectionView election);
	    
	    public Boolean deleteElection(Long id);

		public ElectionView createElection(String electionType, List<RestResourceEntity> entities);

		public ResultPage<ElectionView> getElectionsPagedByType(String electionType, Integer pageNumber, Integer limit);

		public ElectionView disableElection(Long id);

		public ElectionView startElection(Long id);

		public ElectionView endElection(Long id);

		public boolean isValidType(String electionType);

			    
	    
			
}
