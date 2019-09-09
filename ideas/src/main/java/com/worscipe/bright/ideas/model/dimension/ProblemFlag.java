package com.worscipe.bright.ideas.model.dimension;

public enum ProblemFlag {
	NONE,
	CONFLICT, //conflicts with another ideaImpl - triggers Ranked Choice Voting bracket with the conflicting ideaImpl. 
	DUPLICATE, //duplicate of other ideaImpl - triggers ideaImpl merge with branch lock
	
	LAZY, // fails to demonstrate constructive value of the user Examples: memes, images, or quotes reshared
	POOR_SOURCE, // relies on an information that wouldn't qualify in any qualified bibliography
	FALSE_PREMISE, // relies on a objectively false premise that contradicts academically quantifiable consensus.
	EXPLICIT, // adult content that would be generally disallowed without an accompaning academic premise or context
	DISENGENUOUS, // overtly abuses context to manipulate an audience
	VIOLENT, // includes or describes an act of physical harm
	HARASSMENT,  // targets any individual or a group of individuals
	HATE, // does not reflect how someone would want to be subjected if roles were reversed
	SPAM, // not interested in the subject, or presents a confilct of interest to the subject.
	OTHER;
	
	ProblemFlag(){};
}
