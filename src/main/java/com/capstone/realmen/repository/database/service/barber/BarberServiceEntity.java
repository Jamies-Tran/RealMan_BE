package com.capstone.realmen.repository.database.service.barber;

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
@Table(name = "barber_service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BarberServiceEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long barberServiceId;
    @Column(name = "service_category_id")
    Long serviceCategoryId;
    @Column(name = "barber_service_name", nullable = false)
    String barberServiceName;
    @Column(name = "barber_service_price", nullable = false)
    Long barberServicePrice;
}
