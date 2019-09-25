package com.worscipe.bright.ideas.manager;

import java.util.List;

import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.modelview.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;

public interface IdeaManager {
	
	IdeaView convertToView(IdeaImpl ideaImpl);
	List<IdeaView> convertToViews(List<IdeaImpl> ideaImpls);
	
	IdeaImpl convertToImpl(IdeaView ideaView);
	List<IdeaImpl> convertToModels(List<IdeaView> ideaViews);

	
	IdeaView findById(Long id);

	List<IdeaView> findAllIdeas();
	
	List<IdeaView> findAllIdeasByUserId(Long id);
	
	List<IdeaView> findIdeaContributors(IdeaImpl ideaImpl);

	Boolean deleteById(Long id);
	
	ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText);
	IdeaView saveIdea(IdeaView ideaView);
	
	
}
