package com.capstone.realmen.dto.account;

import java.util.Objects;

import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.EParticipantSide;
import lombok.Builder;

@Builder
public record AccountSearchCriteria(
        String search, // first + last name, phone, staffCode
        Long branchId,
        EParticipantSide participantSide,
        EAccountStatus status) {

    public AccountSearchCriteria toLowerCase() {
        return AccountSearchCriteria.builder()
                .search(search.toLowerCase())
                .branchId(branchId)
                .participantSide(participantSide)
                .status(status)
                .build();
    }

    public Boolean hasSearchEmpty() {
        return Objects.isNull(search) || search.isEmpty();
    }

    public Boolean hasBranchIdEmpty() {
        return Objects.isNull(branchId);
    }

    public Boolean hasParticipantSideEmpty() {
        return Objects.isNull(participantSide);
    }

    public Boolean hasStatusEmpty() {
        return Objects.isNull(status);
    }
}
