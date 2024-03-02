package com.capstone.realmen.repository.database.service.barber.display;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberServiceDisplayRepository extends JpaRepository<BarberServiceDisplayEntity, Long> {
    List<BarberServiceDisplayEntity> findAllByBarberServiceId(Long barberServiceId);

    void deleteAllByBarberServiceId(Long barberServiceId);
}
