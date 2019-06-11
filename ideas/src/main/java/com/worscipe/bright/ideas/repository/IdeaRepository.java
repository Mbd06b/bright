package com.worscipe.bright.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.ideas.model.idea.IdeaImpl;

@Repository
public interface IdeaRepository extends JpaRepository<IdeaImpl, Long>, IdeaRepositoryCustom {

	
}
