package com.worscipe.bright.ideas.manager;

import java.util.List;
import java.util.Optional;

import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.modelview.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;

public interface IdeaManager {
	
	IdeaView convertToView(IdeaImpl ideaImpl);
	List<IdeaView> convertToView(List<IdeaImpl> ideaImpls);
	
	IdeaImpl convertToImpl(IdeaView ideaView);
	List<IdeaImpl> convertToImpl(List<IdeaView> ideaViews);

	
	IdeaView findById(Long id);
	List<IdeaView> getIdeas();
	
	Boolean deleteById(Long id);
	
	ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText);
	IdeaView saveIdea(IdeaView ideaView);
	
	List<IdeaView> findIdeasByUser(Long userId);
	
	
}
