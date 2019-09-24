package com.worscipe.bright.ideas.service;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaAudit;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;

public interface IdeaRecordService {

	IdeaAudit logAction(Long entityId, String entityType, IdeaImpl ideaImpl, IdeaAction action);
	
}
