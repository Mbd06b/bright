package com.worscipe.bright.ideas.manager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.worscipe.bright.ideas.model.IdeaImpl;
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
	
	// utilities
	private ModelMapper modelMapper = new ModelMapper(); 
	private Type ideaListType = new TypeToken<List<IdeaImpl>>() {}.getType();
	private Type ideaDtoListType = new TypeToken<List<IdeaView>>() {}.getType();
	
	@Override
	public IdeaView findById(final Long id) {
		
		IdeaImpl ideaImpl = ideaService.findById(id);

		if(ideaImpl != null) {
			IdeaView ideaView = new IdeaView(ideaImpl); 
			return ideaView;  
		}
		return null; 
	}

	@Override
	public List<IdeaView> findAllIdeas() {
		List<IdeaView> ideaViews = this.convertIdeaImplToViewList(ideaService.findAllIdeas()); 
		return ideaViews; 
	}
	
	
	/**
	 * Main search method to query for ideas by value with static pagable values. 
	 * Constructs and returns a view object containing the results and additional information for front-end pagination.
	 */
	@Override
	public ResultPage<IdeaView> getIdeasPageByQueryPageAndSize(Integer pageNumber, Integer limit, String searchText) {
		
		ResultPage<IdeaView> ideaPageView = new ResultPage<>();  
		ideaPageView.setValuesList(this.convertIdeaImplToViewList(this.ideaService.findIdeasByQueryPageAndSize(searchText, pageNumber, limit)));
		ideaPageView.setCurrentPageNum(pageNumber);
		ideaPageView.setNumValuesCurrentPage(ideaPageView.getValuesList().size());
		ideaPageView.setNumValuesPerPageLimit(limit);
		ideaPageView.setTotalResultCount(this.ideaService.getIdeaQueryTotalResultCount(searchText)); 
		ideaPageView.setTotalResultingPages(this.ideaService.getIdeaQueryTotalResultPagesCount(searchText, limit));		
		return ideaPageView;
	}
	
	/**
	 * 
	 * @param findIdeasByQueryPageAndSize
	 * @return
	 */
	private List<IdeaView> convertIdeaImplToViewList(List<IdeaImpl> implList) {
		List<IdeaView> viewList = new ArrayList<>();
		for(IdeaImpl impl : implList) {
			IdeaView view = new IdeaView();
			view.copyFromModel(impl);
			viewList.add(view);
		}
		return viewList; 
	}

	@Override
	public List<IdeaView> findIdeaContributors(IdeaImpl ideaImpl){
		//TODO implement contributors
	return null; 
	}
	
	/**
	 * saveIdea() also handles updates
	 * @return returns the saved or updated object
	 */
	@Override
	public IdeaView saveIdea(IdeaView ideaView) {
		
		IdeaImpl ideaToPersist = convertToImpl(ideaView); 
		IdeaImpl persistedIdea = ideaService.save(ideaToPersist);
		
		ideaRecordService.logAction(ideaView.getActingEntityId(), ideaView.getActingEntityType(), persistedIdea, ideaView.getAction()); 
		
		IdeaView ideaDtoToReturn = convertToView(persistedIdea); 
		
		return  ideaDtoToReturn; 
	
	}

	@Override
	public Boolean deleteById(Long id) {
		return ideaService.deleteById(id);
	}

	@Override
	public List<IdeaView> findAllIdeasByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public IdeaImpl convertToImpl(IdeaView ideaView) {
		return modelMapper.map(ideaView, IdeaImpl.class);
	}
	
	@Override
	public List<IdeaImpl> convertToModels(List<IdeaView> ideaViews) {
		
		List<IdeaImpl> ideas = new ArrayList<>();
		for( IdeaView view : ideaViews) {
		  ideas.add(modelMapper.map(view, IdeaImpl.class));
		}	
		return ideas; 
	}
	
	@Override
	public IdeaView convertToView(IdeaImpl ideaImpl){
		return modelMapper.map(ideaImpl, IdeaView.class);
	}
	
	@Override
	public List<IdeaView> convertToViews(List<IdeaImpl> ideaImpls){
		return modelMapper.map(ideaImpls, ideaDtoListType);
	}
	
}
