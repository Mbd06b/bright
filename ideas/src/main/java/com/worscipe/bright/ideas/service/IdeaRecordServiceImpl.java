package com.worscipe.bright.ideas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaAudit;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.repository.IdeaAuditRepository;

@Service("ideaRecordService")
@Transactional
public class IdeaRecordServiceImpl implements IdeaRecordService{

	@Autowired
	private IdeaAuditRepository ideaAuditRepository; 
	
	@Autowired IdeaService ideaService;
	
	@Override
	public IdeaAudit logAction(Long entityId, String entityType, IdeaImpl ideaImpl, IdeaAction action) {
		
		IdeaAudit log = new IdeaAudit();
					log.setIdea(ideaImpl);
					log.setEntityType(entityType);
					log.setEntityId(entityId);
					log.setIdeaAction(action);
	    
		// save and return the persisted log
		return ideaAuditRepository.save(log);	
	}

}
