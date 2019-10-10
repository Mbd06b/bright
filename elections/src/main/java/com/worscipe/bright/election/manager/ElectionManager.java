package com.worscipe.bright.election.manager;

import java.util.List;

import com.worscipe.bright.election.view.ElectionView;
import com.worscipe.bright.election.view.RestResourceEntity;
import com.worscipe.bright.election.view.ResultPage;

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
