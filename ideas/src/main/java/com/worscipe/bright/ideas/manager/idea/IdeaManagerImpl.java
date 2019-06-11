package com.worscipe.bright.ideas.manager.idea;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.model.user.User;
import com.worscipe.bright.ideas.modelview.idea.IdeaView;
import com.worscipe.bright.ideas.modelview.other.ResultPage;
import com.worscipe.bright.ideas.service.UserService;
import com.worscipe.bright.ideas.service.idea.IdeaRecordService;
import com.worscipe.bright.ideas.service.idea.IdeaService;


@Service
public class IdeaManagerImpl implements IdeaManager {

	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private IdeaRecordService ideaRecordService;
	
	@Autowired
	private UserService userService;
	
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
	public List<User> findIdeaContributors(IdeaImpl ideaImpl){
		
		IdeaImpl theIdea = ideaService.findById(ideaImpl.getIdeaId());
		
		if(theIdea != null) {

			Set<User> userSet = theIdea.getUsers(); 		
		
			List<User> userList = new ArrayList<User>();
			
			userList.addAll(userSet);
			
			return userList;
		
		} else {
			
			return null; 
		}
	}
	
	/**
	 * saveIdea() also handles updates
	 * @return returns the saved or updated object
	 */
	@Override
	public IdeaView saveIdea(IdeaView ideaView) {
		
		User actingUser = userService.findById(ideaView.getActingUserId());
		IdeaImpl ideaToPersist = convertToModel(ideaView); 
		
		ideaToPersist.addUser(actingUser);	
		IdeaImpl persistedIdea = ideaService.save(ideaToPersist);
		ideaRecordService.logAction(userService.findById(ideaView.getActingUserId()) , persistedIdea, ideaView.getAction()); 
		
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
	public IdeaImpl convertToModel(IdeaView ideaView) {
		return modelMapper.map(ideaView, IdeaImpl.class);
	}
	
	@Override
	public List<IdeaImpl> convertToModels(List<IdeaView> ideaViews) {
		
		return modelMapper.map(ideaViews, ideaListType);
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
