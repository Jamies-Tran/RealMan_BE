package com.capstone.realmen.repository.database.service.barber.display;

import com.capstone.realmen.repository.database.auditable.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barber_service_display")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BarberServiceDisplayEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long barberServiceDisplayId;
    @Column(name = "barber_service_id", nullable = false)
    Long barberServiceId;
    @Column(name = "barber_service_display_content", nullable = false)
    String barberServiceDisplayContent;
}
