package com.capstone.realmen.repository.database.auditable;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuditableEntity {
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime updatedAt;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "updated_by")
    String updatedBy;
}
