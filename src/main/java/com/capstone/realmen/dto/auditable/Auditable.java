package com.capstone.realmen.dto.auditable;

import java.time.LocalDateTime;
import com.capstone.realmen.repository.database.auditable.AuditableEntity;
import lombok.Builder;

@Builder
public record Auditable(
        String createdBy,
        LocalDateTime createdAt,
        String updatedBy,
        LocalDateTime updatedAt) {
    // public static Auditable ofWeb(String identifier) {
    //     return Auditable.builder()
    //             .createdBy(identifier)
    //             .createdAt(LocalDateTime.now().plusDays(7))
    //             .updatedBy(identifier)
    //             .updatedAt(LocalDateTime.now().plusDays(7))
    //             .build();
    // }

    public static Auditable of(String identifier) {
        return Auditable.builder()
                .createdBy(identifier)
                .createdAt(LocalDateTime.now())
                .updatedBy(identifier)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Auditable ofNoIdentifier() {
        return Auditable.builder()
                .createdBy("-")
                .createdAt(LocalDateTime.now())
                .updatedBy("-")
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Auditable updateEntity(AuditableEntity entity, String identifier) {
        return Auditable.builder()
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(identifier)
                .build();
    }
}
