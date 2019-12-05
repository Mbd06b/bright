package com.worscipe.bright.ideas.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.ideas.model.IdeaImpl;
import com.worscipe.bright.ideas.model.IdeaRecord;
import com.worscipe.bright.ideas.modelview.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;
import com.worscipe.bright.ideas.service.IdeaRecordService;
import com.worscipe.bright.ideas.service.IdeaService;


@Service
public class IdeaManagerImpl implements IdeaManager {

	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private IdeaRecordService ideaRecordService;
	
	@Override
	public IdeaView findById(final Long id) {
		
		IdeaImpl ideaImpl = ideaService.findById(id);
		if(ideaImpl != null) {
			return convertToView(ideaImpl);  
		}
		return null; 
	}

	@Override
	public List<IdeaView> getIdeas() {
		return convertToView(ideaService.findAllIdeas()); 		
	}
	
	
	/**
	 * Main search method to query for ideas by value with static pagable values. 
	 * Constructs and returns a view object containing the results and additional information for front-end pagination.
	 */
	@Override
	public ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText) {
		
		ResultPage<IdeaView> ideaPageView = new ResultPage<>();  
		ideaPageView.setValuesList(convertToView(ideaService.findIdeasByQueryPageAndSize(searchText, pageNumber, limit)));
		ideaPageView.setCurrentPageNum(pageNumber);
		ideaPageView.setNumValuesCurrentPage(ideaPageView.getValuesList().size());
		ideaPageView.setNumValuesPerPageLimit(limit);
		ideaPageView.setTotalResultCount(ideaService.getIdeaQueryTotalResultCount(searchText)); 
		ideaPageView.setTotalResultingPages(ideaService.getIdeaQueryTotalResultPagesCount(searchText, limit));		
		return ideaPageView;
	}
	
	
	/**
	 * saveIdea() also handles updates
	 * @return returns the saved or updated object
	 */
	@Override
	public IdeaView saveIdea(IdeaView ideaView) {
		
		IdeaImpl ideaToPersist = convertToImpl(ideaView); 
		IdeaRecord record = ideaRecordService.save(new IdeaRecord(ideaView.getActingEntityId(), ideaView.getAction()));
		ideaToPersist.addUser(record);
		IdeaImpl persistedIdea = ideaService.save(ideaToPersist);
				
		IdeaView ideaDtoToReturn = convertToView(persistedIdea); 
		
		return  ideaDtoToReturn; 
	
	}

	@Override
	public Boolean deleteById(Long id) {
		return ideaService.deleteById(id);
	}

	@Override
	public IdeaImpl convertToImpl(IdeaView ideaView) {
		IdeaImpl impl = new IdeaImpl();
		impl.setId(ideaView.getId());
		impl.setTitle(ideaView.getTitle());
		impl.setSubtitle(ideaView.getSubtitle());
		impl.setStory(ideaView.getStory());
		impl.setFeaturedImgUrl(ideaView.getFeaturedImgUrl());
		impl.setThumbnailImgUrl(ideaView.getThumbnailImgUrl());
		return impl;
	}
	
	@Override
	public List<IdeaImpl> convertToImpl(List<IdeaView> ideaViews) {
		List<IdeaImpl> ideas = new ArrayList<>();
		for( IdeaView view : ideaViews) {
		  ideas.add(convertToImpl(view));
		}	
		return ideas; 
	}
	
	@Override
	public IdeaView convertToView(IdeaImpl ideaImpl){
		IdeaView view = new IdeaView(); 
		view.setId(ideaImpl.getId());
		view.setTitle(ideaImpl.getTitle());
		view.setFeaturedImgUrl(ideaImpl.getFeaturedImgUrl());
		view.setStory(ideaImpl.getStory());
		view.setSubtitle(ideaImpl.getSubtitle());
		view.setThumbnailImgUrl(ideaImpl.getThumbnailImgUrl());
		return view; 
	}
	
	@Override
	public List<IdeaView> convertToView(List<IdeaImpl> ideaImpls){
		List<IdeaView> views = new ArrayList<>(); 
		for(IdeaImpl impl: ideaImpls) {
			views.add(convertToView(impl));
		}
		return views; 
	}

	@Override
	public List<IdeaView> findIdeasByUser(Long userId) {
		return convertToView(ideaService.findByUser(userId));
	}

}
