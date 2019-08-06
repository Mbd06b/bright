package com.worscipe.bright.elections.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.elections.model.Election;
import com.worscipe.bright.elections.repository.ElectionRepository;

@Service
public class ElectionServiceImpl implements ElectionService{
	
	@Autowired
	private ElectionRepository electionRepository;

	@Override
	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}
	


}
