package com.capstone.realmen.repository.database.service.barber.display;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberServiceDisplayRepository extends JpaRepository<BarberServiceDisplayEntity, Long> {
    
}
