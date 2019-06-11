package com.worscipe.bright.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.ideas.model.user.UserAudit;

@Repository
public interface UserAuditRepository extends JpaRepository <UserAudit, Long> {

}
