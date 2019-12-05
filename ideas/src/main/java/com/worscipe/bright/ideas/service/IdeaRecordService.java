package com.worscipe.bright.ideas.service;

import com.worscipe.bright.ideas.model.IdeaAction;
import com.worscipe.bright.ideas.model.IdeaRecord;

public interface IdeaRecordService {

	public IdeaRecord logAction(Long entityId, String entityType, IdeaAction action);
	public IdeaRecord save(IdeaRecord ideaRecord); 
}
