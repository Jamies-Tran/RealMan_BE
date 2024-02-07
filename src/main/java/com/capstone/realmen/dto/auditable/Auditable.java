package com.capstone.realmen.dto.auditable;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record Auditable(
        String createdBy,
        LocalDateTime createdAt,
        String updatedBy,
        LocalDateTime updatedAt) {
    public static Auditable ofWeb(String identifier) {
        return Auditable.builder()
                .createdBy(identifier)
                .createdAt(LocalDateTime.now().plusDays(7))
                .updatedBy(identifier)
                .updatedAt(LocalDateTime.now().plusDays(7))
                .build();
    }

    public static Auditable of(String identifier) {
        return Auditable.builder()
                .createdBy(identifier)
                .createdAt(LocalDateTime.now())
                .updatedBy(identifier)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Auditable of() {
        return Auditable.builder()
                .createdBy("-")
                .createdAt(LocalDateTime.now())
                .updatedBy("-")
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
