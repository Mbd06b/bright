package com.worscipe.bright.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.ideas.model.IdeaRecord;

@Repository
public interface IdeaAuditRepository extends JpaRepository<IdeaRecord, Long>{
	
	
}
