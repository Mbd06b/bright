package com.worscipe.bright.elections.model;


public enum ElectionPhase {
	
	OPEN_PHASE   ("The Election has been created but is open for other candidates"),
	VOTING_PHASE ("The Election is set, there is a fixed period of time where ballots can be submitted by eligible voters"),
	INTERIM_PHASE("The Election is in progress, this is an automated calculation phase."),
	FINAL        ("Voting has concluded!"),
	ERROR        ("Something went wrong");
	
	private String description;

	private ElectionPhase(String description) {
		this.description = description;
	}
	
	public String getDescription(){return description;}
}