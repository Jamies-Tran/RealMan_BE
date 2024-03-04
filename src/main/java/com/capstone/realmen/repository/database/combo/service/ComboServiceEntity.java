package com.capstone.realmen.repository.database.combo.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "combo_service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComboServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long comboServiceId;
    @Column(name = "combo_id", nullable = false)
    Long comboId;
    @Column(name = "barber_service_id", nullable = false)
    Long barberServiceId;
}
