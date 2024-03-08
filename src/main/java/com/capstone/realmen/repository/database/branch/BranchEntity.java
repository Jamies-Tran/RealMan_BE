package com.capstone.realmen.repository.database.branch;

import java.time.LocalTime;
import com.capstone.realmen.repository.database.auditable.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "branch")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long branchId;
    @Column(name = "branch_name", nullable = false)
    String branchName;
    @Column(name = "branch_thumbnail")
    String branchThumbnail;
    @Column(name = "branch_street", nullable = false)
    String branchStreet;
    @Column(name = "branch_ward", nullable = false)
    String branchWard;
    @Column(name = "branch_district", nullable = false)
    String branchDistrict;
    @Column(name = "branch_province", nullable = false)
    String branchProvince;
    @Column(name = "latitude")
    Double latitude;
    @Column(name = "longitude")
    Double longitude;
    @Column(name = "open")
    @Temporal(TemporalType.TIME)
    LocalTime open;
    @Column(name = "close")
    @Temporal(TemporalType.TIME)
    LocalTime close;
}
