package com.capstone.realmen.repository.database.branch.display;

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
@Table(name = "branch_display")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchDisplayEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long branchDisplayId;
    @Column(name = "branch_id")
    Long branchId;
    @Column(name = "branch_display_content")
    String branchDisplayContent;
}
