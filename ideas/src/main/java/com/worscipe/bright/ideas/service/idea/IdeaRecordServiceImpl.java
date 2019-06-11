package com.worscipe.bright.ideas.service.idea;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaAudit;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.model.user.User;
import com.worscipe.bright.ideas.repository.IdeaAuditRepository;

@Service("ideaRecordService")
@Transactional
public class IdeaRecordServiceImpl implements IdeaRecordService{

	@Autowired
	private IdeaAuditRepository ideaAuditRepository; 
	
	@Autowired IdeaService ideaService;
	
	@Override
	public IdeaAudit logAction(User user, IdeaImpl ideaImpl, IdeaAction action) {
		
		IdeaAudit log = new IdeaAudit();
					log.setIdea(ideaImpl);
					log.setUser(user);
					log.setIdeaAction(action);
	    
	
		//save and return the persisted log
		return ideaAuditRepository.save(log);
		
	}

}
