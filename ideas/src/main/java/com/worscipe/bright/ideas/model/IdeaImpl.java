package com.worscipe.bright.ideas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Hibernate Annotation Table_Per_Class Strategy Reference
// I'm choosing to increase the complexity for the database query model because 
// close/collaborative Integereractions of the MultiUser/IdeaImpl relationship.
// Also, the temporary life-cycle of an IdeaImpl object, and limited community user scope for any one application instance
// I hope will keep the performance manageable for the increased complexity of the generated Hibernate Queries
// https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/


@Entity
public class IdeaImpl implements Idea{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEA_ID", updatable = false, nullable = false)
    public Long id;
    
	@Column(name="IDEA_TITLE")
    public String title;
    
    @Column(name="IDEA_SUBTITLE")
    public String subtitle; 
 
	@Column(name="IDEA_STORY")
	public String story; 
    
	@Column(name="FEATURED_IMG_URL")
	public String featuredImgUrl;
	
	@Column(name="THUMBNAIL_IMG_URL")
	public String thumbnailImgUrl; 
	
	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdDate = new Date();
	
	@Column(name="MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	public Date modifiedDate = new Date(); 
    
	
//-------COMPOSITION RELATIONSHIPS----------------
    
	//An ideaImpl can have many contributors.
    //Conceptually, an ideaImpl "owns" its contributions. Active users have a record of and can modify their contributions
    //and receive credit for contributions, but if a user deletes their account, unique contributions
    //become owned temporarily/permanently(in some fashion) by the IdeaImpl instance itself.
    //What exactly can/should be done (task generation / owner reassignment) with the orphaned contributions in BrightIdeas is TBD. 
	
	//One ideaImpl has many records. 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="id", orphanRemoval = true) 
	private List<IdeaRecord> users = new ArrayList<>(); 
	
	//One ideaImpl has many records. 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="id", orphanRemoval = true) 
	private List<IdeaRecord> elections = new ArrayList<>(); 
	
	public List<IdeaRecord> getUsers() {
		return users;
	}

	public void setUsers(List<IdeaRecord> users) {
		this.users = users;
	}

	public List<IdeaRecord> getElections() {
		return elections;
	}

	public void setElections(List<IdeaRecord> elections) {
		this.elections = elections;
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

	@Override
	public String toString() {
		return "IdeaImpl["+ id + "]: " + title; 
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
