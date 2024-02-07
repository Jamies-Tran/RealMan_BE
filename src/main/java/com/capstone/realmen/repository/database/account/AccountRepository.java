package com.capstone.realmen.repository.database.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.dto.enums.EParticipantSide;
import com.capstone.realmen.dto.enums.ERole;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Query("""
            SELECT a
            FROM AccountEntity a
            WHERE a.phone = :phoneOrStaffCode OR a.staffCode = :phoneOrStaffCode
            """)
    Optional<AccountEntity> findByPhoneOrStaffCode(String phoneOrStaffCode);

    Optional<AccountEntity> findByPhone(String phone);

    Optional<AccountEntity> findByStaffCode(String staffCode);

    Boolean existsByPhone(String phone);

    Boolean existsByStaffCode(String staffCode);

    Boolean existsByPassword(String password);

    @Query("""
            SELECT a
            FROM AccountEntity a
            WHERE (:#{#searchCriteria.hasSearchEmpty()} = TRUE
                    OR (LOWER(CONCAT(a.firstName, a.lastName)) LIKE %:#{#searchCriteria.search()}%
                    OR a.phone LIKE %:#{#searchCriteria.search()}%
                    OR LOWER(a.staffCode) LIKE %:#{#searchCriteria.search()}%))
                AND (:#{#searchCriteria.hasBranchIdEmpty()} = TRUE OR a.branchId = :#{#searchCriteria.branchId()})
                AND (:#{#searcCriteria.hasParticipantSideEmpty()} = TRUE
                    OR CASE
                        WHEN :#{#searchCriteria.participantSide()} = com.capstone.realmen.dto.enums.EParticipantSide.BARBER THEN a.role IN (SHOPOWNER, STYLIST)
                        ELSE a.role = CUSTOMER
                    END)
            """)
    Page<AccountEntity> pageAll(AccountSearchCriteria searchCriteria, Pageable pageable);
}
