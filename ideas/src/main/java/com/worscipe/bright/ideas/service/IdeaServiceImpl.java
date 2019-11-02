package com.worscipe.bright.ideas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.IdeaAction;
import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.model.IdeaRecord;
import com.worscipe.bright.ideas.modelview.IdeaView;
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
		return ideaRepository.findAll(); 
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
	
	
	/**
	 * saveIdea() also handles updates
	 * @return returns the saved or updated object
	 */
	@Override
	public IdeaImpl save(IdeaImpl ideaImpl) {
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

	@Override
	public Optional<List<IdeaImpl>> findByUser(Long userId) {
		IdeaImpl idea = new IdeaImpl();
		IdeaRecord record = new IdeaRecord(); 
		record.setEntityId(userId);
		
		List<IdeaRecord> c = new ArrayList<>();
		c.add(record);
		 idea.setUsers(c);
		 
		Example<IdeaImpl> example = Example.of(idea);
		
		return Optional.of(ideaRepository.findAll(example));
	}

	@Override
	public Set<Long> findIdeaContributors(IdeaImpl id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Long> findIdeaContributors(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
