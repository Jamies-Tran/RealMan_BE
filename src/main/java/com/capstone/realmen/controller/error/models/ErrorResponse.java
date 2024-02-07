package com.capstone.realmen.controller.error.models;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ErrorResponse(
                String errorCode,
                String errorMsg,
                Integer statusCode,
                String status,
                LocalDateTime issueAt) {
}
