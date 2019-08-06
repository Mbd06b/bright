package com.worscipe.bright.elections.service;

import java.util.List;
import java.util.Optional;

import com.worscipe.bright.elections.model.Election;

public interface ElectionService<E extends Election> {
	
	List<E> getAllElections();
	
	Optional<E> getElection(Long id); 
}
