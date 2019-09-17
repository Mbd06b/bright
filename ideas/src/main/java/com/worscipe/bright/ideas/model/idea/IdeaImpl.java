package com.worscipe.bright.ideas.model.idea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
>>>>>>> refs/remotes/origin/master
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
@Table(name="IDEA_TABLE")
public class IdeaImpl{


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
	public Date createdOn = new Date();
    
	
//-------COMPOSITION RELATIONSHIPS----------------
    
	//An ideaImpl can have many contributors.
    //Conceptually, an ideaImpl "owns" its contributions. Active users have a record of and can modify their contributions
    //and receive credit for contributions, but if a user deletes their account, unique contributions
    //become owned temporarily/permanently(in some fashion) by the IdeaImpl instance itself.
    //What exactly can/should be done (task generation / owner reassignment) with the orphaned contributions in BrightIdeas is TBD. 
	
	//One ideaImpl has many records. 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="id", orphanRemoval = true) 
	private List<IdeaAudit> ideaAudits = new ArrayList<IdeaAudit>(); 
	
	public void setIdeaLogs(List<IdeaAudit> ideaAudits){
		this.ideaAudits = ideaAudits;
	}
	
	public List<IdeaAudit> getIdeaLogs(){
		return this.ideaAudits; 
	}
<<<<<<< HEAD
=======
	
	
	// elections handles up/dn votes, reactions, brackets, and user preferences. 
	@ElementCollection
	private Set<Long> electionIds;
	
	
	
//----- CONSTRUCTORS ----------------
	
	
	public IdeaImpl(){	
	}
	
	
	/**
	 * 
	 * @param title - ideaImpl Title
	 * @param subtitle - ideaImpl Subtitle
	 */
	
  public IdeaImpl(String title, String subtitle){
		this.title =  title; 
		this.subtitle = subtitle; 
	}
>>>>>>> refs/remotes/origin/master
  
	
//-------- METHODS -------------------
	public Long getIdeaId() {
		return id;
	}

	public void setIdeaId(Long id) {
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

	public List<IdeaAudit> getIdeaRecords() {
		return ideaAudits;
	}

	public void setIdeaRecords(List<IdeaAudit> ideaAudits) {
		this.ideaAudits = ideaAudits;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
<<<<<<< HEAD
	
=======

	public Set<Long> getElectionIds() {
		return electionIds;
	}

	public void setElectionIds(Set<Long> electionIds) {
		this.electionIds = electionIds;
	}



>>>>>>> refs/remotes/origin/master
}
