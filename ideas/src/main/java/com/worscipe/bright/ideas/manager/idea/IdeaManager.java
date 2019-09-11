package com.worscipe.bright.ideas.manager.idea;

import java.util.List;

import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.model.user.User;
import com.worscipe.bright.ideas.modelview.idea.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;

public interface IdeaManager {
	
	IdeaView convertToView(IdeaImpl ideaImpl);
	List<IdeaView> convertToViews(List<IdeaImpl> ideaImpls);
	
	IdeaImpl convertToModel(IdeaView ideaView);
	List<IdeaImpl> convertToModels(List<IdeaView> ideaViews);

	
	IdeaView findById(Long id);

	List<IdeaView> findAllIdeas();
	
	List<IdeaView> findAllIdeasByUserId(Long id);
	
	List<User> findIdeaContributors(IdeaImpl ideaImpl);


	IdeaView saveIdea(IdeaView idea);

	Boolean deleteById(Long id);
	
	ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText);
	
	
}
