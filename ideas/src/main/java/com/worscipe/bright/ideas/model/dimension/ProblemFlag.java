package com.worscipe.bright.ideas.model.dimension;

public enum ProblemFlag {
	NONE,
	CONFLICT, //conflicts with another ideaImpl - triggers Ranked Choice Voting bracket with the conflicting ideaImpl. 
	DUPLICATE, //duplicate of other ideaImpl - triggers ideaImpl merge with branch lock
	IGNORANT,
	EXPLICIT,
	DISENGENUOUS,
	VIOLENT,
	HARASSMENT,
	HATE,
	SPAM,
	OTHER;
	
	ProblemFlag(){};
}
