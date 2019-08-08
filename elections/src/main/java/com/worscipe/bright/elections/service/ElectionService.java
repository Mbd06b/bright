package com.worscipe.bright.elections.service;

import java.util.List;
import java.util.Optional;


public interface ElectionService {
	
	List<?> getAllElections();
	
	Optional<?> getElection(Long id); 

	Boolean deleteById(Long id); 
	
	
}