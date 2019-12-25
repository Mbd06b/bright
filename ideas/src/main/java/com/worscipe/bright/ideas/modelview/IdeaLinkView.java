package com.worscipe.bright.ideas.modelview;

import java.io.Serializable;

import com.worscipe.bright.ideas.model.IdeaImpl;

public class IdeaLinkView implements Serializable {
	
	private static final long serialVersionUID = 2669423133607535724L;

		public Long id;
	    
	    public String title;
	    
	    public String subtitle; 
	 
		public String story; 
		
		public String thumbnailImgUrl;
		
		public IdeaLinkView(){}
		
		public IdeaLinkView(IdeaImpl ideaImpl){
			this.id = ideaImpl.getId();
			this.title = ideaImpl.getTitle();
			this.subtitle = ideaImpl.getSubtitle();
			this.story =ideaImpl.getStory();
			this.thumbnailImgUrl = ideaImpl.getThumbnailImgUrl();
		}

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

		public String getThumbnailImgUrl() {
			return thumbnailImgUrl;
		}

		public void setThumbnailImgUrl(String thumbnailImgUrl) {
			this.thumbnailImgUrl = thumbnailImgUrl;
		} 

		
}
