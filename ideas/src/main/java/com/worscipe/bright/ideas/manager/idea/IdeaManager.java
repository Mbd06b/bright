package com.worscipe.bright.ideas.manager.idea;

import java.util.List;

import com.worscipe.bright.ideas.model.idea.IdeaImpl;
<<<<<<< HEAD
=======
import com.worscipe.bright.ideas.model.user.User;
>>>>>>> refs/remotes/origin/master
import com.worscipe.bright.ideas.modelview.idea.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;
import com.worscipe.bright.ideas.modelview.user.UserView;

public interface IdeaManager {
	
	IdeaView convertToView(IdeaImpl ideaImpl);
	List<IdeaView> convertToViews(List<IdeaImpl> ideaImpls);
	
	IdeaImpl convertToImpl(IdeaView ideaView);
	List<IdeaImpl> convertToModels(List<IdeaView> ideaViews);

	
	IdeaView findById(Long id);

	List<IdeaView> findAllIdeas();
	
	List<IdeaView> findAllIdeasByUserId(Long id);
	
	List<UserView> findIdeaContributors(IdeaImpl ideaImpl);

	Boolean deleteById(Long id);
	
	ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText);
	IdeaView saveIdea(IdeaView ideaView);
	
	
}
