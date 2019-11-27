package com.worscipe.bright.users.service;

import java.util.List;
import java.util.Optional;

import com.worscipe.bright.users.model.UserRecord;

public interface RecordService {
	
	public UserRecord save(UserRecord userRecord);
	
	public UserRecord getRecord(Long id);
	
	public void deleteById(Long id);
	
	public void delete(UserRecord userRecord);

	List<UserRecord> getUserIdeas(Long id);

	List<UserRecord> getUserElections(Long id);
	

}
