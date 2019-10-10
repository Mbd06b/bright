package com.worscipe.bright.election.repository.rcv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.election.model.rcv.RCVElectionImpl;

@Repository
public interface RCVElectionRepository extends JpaRepository<RCVElectionImpl,Long>{

}
