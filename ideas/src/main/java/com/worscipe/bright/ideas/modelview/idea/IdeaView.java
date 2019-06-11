package com.worscipe.bright.ideas.modelview.idea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.worscipe.bright.ideas.model.idea.IdeaAction;
import com.worscipe.bright.ideas.model.idea.IdeaImpl;
import com.worscipe.bright.ideas.modelview.user.UserLinkView;

public class IdeaView implements Serializable{
	
	private static final long serialVersionUID = 5235679243658929664L;

    private Long id;
    
    private String title;
    
    private String subtitle; 
 
	private String story; 
	
	private String featuredImgUrl;

	private String thumbnailImgUrl;
	
	private Long actingUserId; 
	
	private IdeaAction action;

	
//--------IdeaImpl States ------------------------ 
	


	public IdeaAction getAction() {
		return action;
	}

	public void setAction(IdeaAction action) {
		this.action = action;
	}

	public Long getActingUserId() {
		return actingUserId;
	}

	public void setActingUserId(Long actingUserId) {
		this.actingUserId = actingUserId;
	}



	
//----- CONSTRUCTORS ----------------
	
	
	public IdeaView(){	
	}
	
	public IdeaView(IdeaImpl ideaImpl) {
		 this.id = ideaImpl.getIdeaId(); 
		 this.title = ideaImpl.getTitle(); 
		 this.subtitle = ideaImpl.getSubtitle();
		 this.story = ideaImpl.getStory(); 	   
	}
	
	
	/**
	 * 
	 * @param title - ideaImpl Title
	 * @param subtitle - ideaImpl Subtitle
	 */
	
  public IdeaView(String title, String subtitle){
		this.title =  title; 
		this.subtitle = subtitle; 
	}

	
//-------- METHODS -------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle() {
		return subtitle; 
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle; 
	}
	
	public String getStory() {
		return story; 
	}
	
	public void setStory(String story) {
		this.story = story; 
	}

	public String getFeaturedImgUrl() {
		return featuredImgUrl;
	}

	public void setFeaturedImgUrl(String featuredImgUrl) {
		this.featuredImgUrl = featuredImgUrl;
	}

	public String getThumbnailImgUrl() {
		return thumbnailImgUrl;
	}

	public void setThumbnailImgUrl(String thumbnailImgUrl) {
		this.thumbnailImgUrl = thumbnailImgUrl;
	}
	
	public String toString() {
		return "Get Class: " + this.getClass() + " IdeaImpl: " + title + " id: " + id + " Subtitle: " + subtitle; 
	}

	public void copyFromModel(IdeaImpl impl) {
		 this.id = impl.getIdeaId(); 
		 this.title = impl.getTitle(); 
		 this.subtitle = impl.getSubtitle();
		 this.story = impl.getStory(); 	   
	}


}
