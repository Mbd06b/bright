package com.worscipe.bright.elections.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.elections.model.Election;
import com.worscipe.bright.elections.model.rcv.RCVElectionImpl;
import com.worscipe.bright.elections.repository.rcv.RCVElectionRepository;

@Service
public class AbstractElectionService<E> implements ElectionService {
	
	@Autowired
	private RCVElectionRepository rcvElectionRepository;

	@Override
	public List<RCVElectionImpl> getAllElections() {
		return rcvElectionRepository.findAll();
	}

	@Override
	public Optional<E> getElection(Long id) {
		return rcvElectionRepository.findById(id);
	}
	


}
