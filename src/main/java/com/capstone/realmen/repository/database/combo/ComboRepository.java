package com.capstone.realmen.repository.database.combo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<ComboEntity, Long> {
    
}