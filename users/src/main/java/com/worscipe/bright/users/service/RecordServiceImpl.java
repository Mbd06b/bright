package com.worscipe.bright.users.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.model.UserImpl;
import com.worscipe.bright.users.model.UserRecord;
import com.worscipe.bright.users.repository.UserRecordRepository;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private UserRecordRepository userRecordRepository;
	
	@Autowired
	private UserService userService;  
	
	
	@Override
	public List<UserRecord> getUserIdeas(Long id) {
		UserImpl userImpl = userService.findById(id);
		return userImpl.getIdeas().stream().collect(Collectors.toList()); 
	}
	
	@Override
	public List<UserRecord> getUserElections(Long id){
		UserImpl userImpl = userService.findById(id);
		return userImpl.getElections().stream().collect(Collectors.toList()); 
	}
	
	
	
	@Override
	public UserRecord save(UserRecord userRecord) {
		return userRecordRepository.save(userRecord);
	}
	
	@Override
	public UserRecord getRecord(Long id) {
		Optional<UserRecord> userRecord = userRecordRepository.findById(id); 
		if (userRecord.isPresent()) {
			return userRecord.get();
		} else {
			return new UserRecord();
		}
		
	}
	
	public void deleteById(Long id) {
		userRecordRepository.deleteById(id);		
	}
	
	public void delete(UserRecord userRecord) {
		userRecordRepository.delete(userRecord); 
	}

	@Override
	public boolean purgeIdea(Long ideaId) {
		// TODO delete all User Records (purge) from USER_IDEAS that have an entityId = ideaId
		return false;
	}

	@Override
	public boolean purgeElection(Long electionId) {
		// TODO delete all UserRecords (purge) from USER_ELECTIONS that have an entityId = electionId
		return false;
	}
	
	
	
}
