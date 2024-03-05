package com.capstone.realmen.repository.database.combo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboServiceRepository extends JpaRepository<ComboServiceEntity, Long> {
    void deleteAllByComboId(Long comboId);
}
