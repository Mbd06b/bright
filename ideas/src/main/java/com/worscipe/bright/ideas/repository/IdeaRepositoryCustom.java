package com.worscipe.bright.ideas.repository;

import java.util.List;

import com.worscipe.bright.ideas.model.idea.IdeaImpl;

public interface IdeaRepositoryCustom {
	Long getIdeaQueryTotalResultCount(String searchText);

	Integer getIdeaQueryTotalResultPagesCount(String searchText, Integer limit);

	List<IdeaImpl> findIdeasByQueryPageAndSize(String searchText, Integer pageNumber, Integer limit);
}
