package com.capstone.realmen.repository.database.branch.service;

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
@Table(name = "branch_service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long branchServiceId;
    @Column(name = "branch_id")
    Long branchId;
    @Column(name = "barber_service_id")
    Long barberServiceId;
}
