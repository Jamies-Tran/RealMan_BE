package com.capstone.realmen.repository.database.service.category;

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
@Table(name = "service_category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceCategoryEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long serviceCategoryId;
    @Column(name = "service_category_code", nullable = false)
    String serviceCategoryCode;
    @Column(name = "service_category_name", nullable = false)
    String serviceCategoryName;
}
