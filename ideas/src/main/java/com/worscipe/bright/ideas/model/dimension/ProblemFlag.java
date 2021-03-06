package com.worscipe.bright.ideas.model.dimension;

public enum ProblemFlag {
	NONE,
	CONFLICT, // conflicts with another ideaImpl - triggers Ranked Choice Voting bracket with the conflicting ideaImpl. 
	DUPLICATE, // duplicate of other ideaImpl - triggers ideaImpl merge with branch lock
	
	OFF_TOPIC, // content which could overcomplicate or frustrate the topic and should be moved for separate development
	
	CONTAGION, // has previously been identified as false or misleading by a reputable non-partisan institution
	LAZY, // fails to demonstrate constructive value of the user Examples: memes, images, or quotes reshared
	POOR_SOURCE, // relies on an information that wouldn't qualify in any qualified bibliography
	FALSE_PREMISE, // relies on a objectively false premise that contradicts academically quantifiable consensus.
	EXPLICIT, // adult content that would be generally disallowed without an accompaning academic premise or context
	DISENGENUOUS, // overtly selects context, or omits context to mislead an audience
	VIOLENT, // includes or describes an act of physical harm
	HARASSMENT,  // targets any individual or minority group
	HATE, // does not reflect how someone would want to be subjected if roles were reversed
	SPAM, // uninsterested in the subject, or is not in the interest of the participants as established by an independent feduciary
	OTHER;
	
	ProblemFlag(){};
}
