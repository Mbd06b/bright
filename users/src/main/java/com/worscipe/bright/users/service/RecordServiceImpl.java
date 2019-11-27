package com.worscipe.bright.users.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.model.User;
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
		User user = userService.findById(id);
		return user.getIdeas().stream().collect(Collectors.toList()); 
	}
	
	@Override
	public List<UserRecord> getUserElections(Long id){
		User user = userService.findById(id);
		return user.getElections().stream().collect(Collectors.toList()); 
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
	
	
	
}
