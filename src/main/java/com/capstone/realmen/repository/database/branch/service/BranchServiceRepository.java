package com.capstone.realmen.repository.database.branch.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchServiceRepository extends JpaRepository<BranchServiceEntity, Long>{
    
}
