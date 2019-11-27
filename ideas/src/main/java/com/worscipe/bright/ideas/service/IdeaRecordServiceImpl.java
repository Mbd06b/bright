package com.worscipe.bright.ideas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.IdeaAction;
import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.model.IdeaRecord;
import com.worscipe.bright.ideas.repository.IdeaRecordRepository;

@Service("ideaRecordService")
@Transactional
public class IdeaRecordServiceImpl implements IdeaRecordService{

	@Autowired
	private IdeaRecordRepository ideaRecordRepository; 
	
	@Override
	public IdeaRecord save(IdeaRecord ideaRecord) {
		return ideaRecordRepository.save(ideaRecord);
	}
	
	
	@Override
	public IdeaRecord logAction(Long entityId, String entityType, IdeaImpl ideaImpl, IdeaAction action) {
		
		IdeaRecord log = new IdeaRecord();
					log.setIdea(ideaImpl);
					log.setEntityId(entityId);
					log.setIdeaAction(action);
	    
		// save and return the persisted log
		return ideaRecordRepository.save(log);	
	}

}
