package com.worscipe.bright.ideas.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.IdeaAction;
import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.repository.IdeaRepository;

@Service("ideaService")
@Transactional
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private IdeaRepository ideaRepository;

	@Override
	public IdeaImpl findById(final Long id) {
		
		Optional<IdeaImpl> ideaImpl = ideaRepository.findById(id);
		
		if(ideaImpl.isPresent()) {
			return ideaImpl.get();  
		}
		return null; 
	}

	@Override
	public List<IdeaImpl> findAllIdeas() {
		
		List<IdeaImpl> ideaImpls = ideaRepository.findAll(); 
	
		return ideaImpls; 
	}
	
	@Override
	public List<IdeaImpl> findIdeasByQueryPageAndSize(String searchText, Integer pageNumber, Integer limit) {
		return this.ideaRepository.findIdeasByQueryPageAndSize(searchText, pageNumber, limit); 
	}

	@Override
	public Long getIdeaQueryTotalResultCount(String searchText) {
		return this.ideaRepository.getIdeaQueryTotalResultCount(searchText);
	}

	@Override
	public Integer getIdeaQueryTotalResultPagesCount(String searchText, Integer limit) {
		return this.ideaRepository.getIdeaQueryTotalResultPagesCount(searchText, limit);
	}

	
	@Override
	public Set<Long> findIdeaContributors(Long id){
		// TODO implement findIdeaContributors()
		return null;
	}
	
	@Override
	public Set<Long> findIdeaContributors(IdeaImpl ideaImpl){
		// TODO implement findIdeaContributors()
		return null;
	}
	
	
	
	@Override
	public List<IdeaImpl> findAllIdeasByUserId(Long id){
		
	// TODO Fix this Query to return something useful.  Research: JPARepository.findAllById(Iterable<Long>) method. 		
		List<IdeaImpl> ideaImpls = ideaRepository.findAll();
		
		return ideaImpls;
	}
	
	/**
	 * saveIdea() also handles updates
	 * @return returns the saved or updated object
	 */
	@Override
	public IdeaImpl save(IdeaImpl ideaImpl) {
		//IdeaAudit "logging" service requested from IdeaManager;
		return ideaRepository.save(ideaImpl); 
	}
	

	
	@Override
	public void logAction(IdeaAction actionType) {
		
	}

	@Override
	public Boolean deleteById(Long id) {
		
		if(findById(id) != null){
			ideaRepository.deleteById(id);
			return true; 
		} else {
			return false;
		}
	}

	@Override
	public Boolean existsById(Long id) {
		if(findById(id) != null){
			return true; 
		} else {
			return false;
		}
	}


	
}
