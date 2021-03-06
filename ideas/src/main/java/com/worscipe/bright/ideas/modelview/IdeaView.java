package com.worscipe.bright.ideas.modelview;

import java.io.Serializable;

import com.worscipe.bright.ideas.model.IdeaAction;

public class IdeaView implements Serializable{
	
	private static final long serialVersionUID = 5235679243658929664L;

    private Long id;
    
    private String title;
    
    private String subtitle; 
 
	private String story; 
	
	private String featuredImgUrl;

	private String thumbnailImgUrl;
	
	private Long actingEntityId;
	private String actingEntityType;
	
	private IdeaAction action;

	
//--------IdeaImpl States ------------------------ 
	


	public IdeaAction getAction() {
		return action;
	}

	public void setAction(IdeaAction action) {
		this.action = action;
	}

	public Long getActingEntityId() {
		return actingEntityId;
	}

	public void setActingEntityId(Long actingEntityId) {
		this.actingEntityId = actingEntityId;
	}
	
	public String getActingEntityType() {
		return this.actingEntityType; 
	}
	
	public void setEntityType(String actingEntityType) {
		 this.actingEntityType = actingEntityType;
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
}
