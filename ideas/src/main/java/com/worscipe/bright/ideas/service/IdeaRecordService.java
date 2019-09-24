package com.worscipe.bright.ideas.service;

import com.worscipe.bright.ideas.model.IdeaAction;
import com.worscipe.bright.ideas.model.IdeaAudit;
import com.worscipe.bright.ideas.model.IdeaImpl;

public interface IdeaRecordService {

	IdeaAudit logAction(Long entityId, String entityType, IdeaImpl ideaImpl, IdeaAction action);
	
}
