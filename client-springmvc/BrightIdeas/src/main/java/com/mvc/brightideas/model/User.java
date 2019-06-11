package com.mvc.brightideas.model;

import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = -1634050238675796539L;


	private Long id;

	// used as login                              
	private String email;

	private String password;


	private String firstName;


	private String lastName;

//	// -------COMPOSITION RELATIONSHIPS----------------
//	
//	
//	//See Idea.java for details on the User-Idea relationship. 
//	// Transient means that this field is not intended to be persisted or serialized as part of
//	// the user object
//	@Transient
//	public Idea idea;
//
//	// https://www.baeldung.com/hibernate-many-to-many
//
//	//Users have a set of ideas that they have contributed to.
//	@ManyToMany	
//	private Set<Idea> ideas = new HashSet<>(); 
//	
//	public Set<Idea> getIdeas(){
//		return ideas;
//	}
//	
//	public void setIdeas(Set<Idea> ideas) {
//		this.ideas = ideas; 
//	}
//	
	
//-----Constructors--------

	public User() {
	}

	/**
	 * 
	 * @param id
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public User(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

//----Methods--------------		

	// TODO refactor to match id Property
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[User:" + id + " Info] email: " + email + " firstName: " + firstName + " lastName: " + lastName + " password: " + password;
	}

}
