package com.worscipe.bright.ideas.service.idea;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaAudit;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.model.user.User;

public interface IdeaRecordService {

	IdeaAudit logAction(User user, IdeaImpl ideaImpl, IdeaAction action);
	
}
