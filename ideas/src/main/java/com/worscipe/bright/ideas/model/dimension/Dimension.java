package com.worscipe.bright.ideas.model.dimension;

import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Dimension {
	
	
	
	/** These states are qualitative "buckets" but also provide stub functionality.
	*   as the application matures the states/dimensions can programmatically determined.
	*   and/or backed by some data representation like vectors/tensors that can feedback meaningful insight
	*   Integero user dashboards.
	
	 
	* Root concept: Bloom's Taxonomy
	*  1. Knowledge - to know, identify describe, list, label, name.
	*		- NEW,
	*  2. Comprehension - To understand, Integererpret, restate, rewrite, summarize, contrast, and explain
	*				- GROWING, COMPRISING
	*  3. Application - To apply knowledge to new situation solve problems, to practice models. 
	*				- TRANSITIONING, READY, APPLYING, 
	* 
	*  
	*  4. Analysis - To identify the organizational structure of something to identify parts,
	*					 relationships and organizing principles.
	*		  Synthesis - To create something, to Integeregrate ideas Integero a solution
	*	                to formulate a new classification scheme.  
	*	    Evaluation -To judge the quality of something based on it's adequacy, 
	*	                 value, logic or use.
	*	             - RESOLVED
	*/


	// Concept: The Eisenhower  Matrix
	@Enumerated(EnumType.STRING) 
	private Urgency urgency = Urgency.UNKNOWN;
	@Enumerated(EnumType.STRING)
	private Importance importance = Importance.UNKNOWN; 
	
	
	// based on binary vote, relative to the size of active community participation.
	@Enumerated(EnumType.STRING) 
	private Popularity popularity = Popularity.UNKNOWN;
	
	
	//concern triggered based on distribution of the binary votes (50up, 50dn), 
	//controversial designations earned from explicit user feedback, or admin Integerervention
	@Enumerated(EnumType.STRING) 
	private Controversy controversy = Controversy.UNKNOWN;
	
	@Enumerated(EnumType.STRING) 
	private Complexity complexity = Complexity.UNKNOWN;
	
	@Enumerated(EnumType.STRING) 
	private Maturity maturity = Maturity.NEW;
	
	
	//TODO create a way for the application understand the financial context of the application,
	//the resources of the user community.
	//set relative to . 
	@Enumerated(EnumType.STRING) 
	private FinancialCost financialCost = FinancialCost.UNKNOWN;
	
	// economics101 - never leave out the opportunity cost. Set relative to financial context
	@Enumerated(EnumType.STRING) 
	private OpportunityCost opportunityCost = OpportunityCost.UNKNOWN;
	
	
	// problem flags are either triggered manually or automatically for moderator intervention
	/** TODO consider ways to analyze/predict levels of 
	* "intent"... ignorance, passively motivated, and malicious intent
	*  
	*  This Interacts with the Political/Vaulues Hazard Awareness policies.
	*/

	private Set<ProblemFlag> problemFlags;
   
   public Complexity getComplexity() {
		return complexity;
	}
	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}
	public Controversy getControversy() {
		return controversy;
	}
	public void setControversy(Controversy controversy) {
		this.controversy = controversy;
	}
	public FinancialCost getFinancialCost() {
		return financialCost;
	}
	public void setFinancialCost(FinancialCost financialCost) {
		this.financialCost = financialCost;
	}
	public Importance getImportance() {
		return importance;
	}
	public void setImportance(Importance importance) {
		this.importance = importance;
	}
	public Maturity getMaturity() {
		return maturity;
	}
	public void setMaturity(Maturity maturity) {
		this.maturity = maturity;
	}
	public OpportunityCost getOpportunityCost() {
		return opportunityCost;
	}
	public void setOpportunityCost(OpportunityCost opportunityCost) {
		this.opportunityCost = opportunityCost;
	}
	public Set<ProblemFlag> getProblemFlags() {
		return problemFlags;
	}
	public void setProblemFlags(Set<ProblemFlag> problemFlags) {
		this.problemFlags = problemFlags;
	}
	public Popularity getPopularity() {
		return popularity;
	}
	public void setPopularity(Popularity popularity) {
		this.popularity = popularity;
	}
	public Urgency getUrgency() {
		return urgency;
	}
	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}
}
