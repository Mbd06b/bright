package com.worscipe.bright.ideas.service.idea;

import java.util.List;
import java.util.Set;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;

public interface IdeaService {

	IdeaImpl findById(Long id);

	List<IdeaImpl> findAllIdeas();
	
	Set<Long> findIdeaContributors(IdeaImpl id);
	Set<Long> findIdeaContributors(Long id);
	
	IdeaImpl save(IdeaImpl ideaImpl);

	void logAction(IdeaAction action);

	Boolean deleteById(Long id);

	List<IdeaImpl> findAllIdeasByUserId(Long id);

	Boolean existsById(Long id);

	List<IdeaImpl> findIdeasByQueryPageAndSize(String searchText, Integer pageNumber, Integer limit);

	Long getIdeaQueryTotalResultCount(String searchText);

	Integer getIdeaQueryTotalResultPagesCount(String searchText, Integer limit);
}
