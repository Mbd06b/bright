package com.worscipe.bright.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.users.model.UserRecord;

@Repository
public interface UserRecordRepository extends JpaRepository <UserRecord, Long> {
	
}
