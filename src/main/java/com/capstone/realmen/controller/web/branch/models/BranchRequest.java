package com.capstone.realmen.controller.web.branch.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import java.util.List;
import java.time.LocalDateTime;

@Builder
public record BranchRequest(
                @NotNull String branchName,
                String branchThumbnail,
                @NotNull String branchAddress,
                @NotNull LocalDateTime open,
                @NotNull LocalDateTime close,
                List<BranchServiceRequest> branchServices,
                @Size(min = 3) List<BranchDisplayRequest> branchDisplays) {
        public LocalDateTime open() {
                return open.minusHours(7);
        }

        public LocalDateTime close() {
                return close.minusHours(7);
        }

}
