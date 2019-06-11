package com.mvc.brightideas.model;

import java.io.Serializable;


public class Idea implements Serializable{
	
	private static final long serialVersionUID = 5506499344664073676L;

	public Long id;
    
    public String title;
    
    public String subtitle; 
 
	public String story; 
  
    
	
//-------COMPOSITION RELATIONSHIPS----------------
    

	public User actingUser; 
	
	
//--------Idea States ------------------------ 
	


	//0 - null, 1 - not Solved, 2 - Solved
	public int isSolved = 0; 
	

	//--------Sort and Analysis values -----------

	public int energyPoints; 
	
	public int upVotes;
	
	public int downVotes; 
	
	

	
//----- CONSTRUCTORS ----------------
	
	
	public Idea(){	
	}
	
	
	
	
	/**
	 * 
	 * @param title - idea Title
	 * @param subtitle - idea Subtitle
	 */
	
  public Idea(String title, String subtitle){
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

	public User getActingUser() {
		return actingUser;
	}

	public void setActingUser(User user) {
		this.actingUser = user;
	}
	

	public int getIsSolved() {
		return isSolved;
	}

	public void setIsSolved(int isSolved) {
		this.isSolved = isSolved;
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
	

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDnVotes() {
		return downVotes;
	}

	public void setDnVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	
	
	public String toString() {
		return "Get Class: " + this.getClass() + " Idea: " + title + " ideaId: " + id + " Subtitle: " + subtitle; 
	}


}
