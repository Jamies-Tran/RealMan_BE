package com.capstone.realmen.repository.database.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.info.account.AccountInfo;

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
            SELECT
                a.accountId AS accountId,
                a.branchId AS branchId,
                a.firstName AS firstName,
                a.lastName AS lastName,
                a.phone AS phone,
                a.password AS password,
                a.staffCode AS staffCode,
                a.role AS role,
                a.thumbnail AS thumbnail,
                a.dob AS dob,
                a.gender AS gender,
                a.accountStatus AS accountStatus
            FROM AccountEntity a
            WHERE a.accountId = :accountId
            """)
    Optional<AccountInfo> findInfoById(Long accountId);

    @Query("""
            SELECT
                a.accountId AS accountId,
                a.branchId AS branchId,
                a.firstName AS firstName,
                a.lastName AS lastName,
                a.phone AS phone,
                a.password AS password,
                a.staffCode AS staffCode,
                a.role AS role,
                a.thumbnail AS thumbnail,
                a.dob AS dob,
                a.gender AS gender,
                a.accountStatus AS accountStatus
            FROM AccountEntity a
            WHERE (:#{#searchCriteria.hasSearchEmpty()} = TRUE
                    OR LOWER(CONCAT(a.firstName, ' ' , a.lastName)) LIKE %:#{#searchCriteria.search}%
                    OR a.phone LIKE %:#{#searchCriteria.search}%
                    OR a.staffCode LIKE %:#{#searchCriteria.search}%)
                AND (:#{#searchCriteria.hasBranchIdEmpty()} = TRUE
                    OR a.branchId = :#{#searchCriteria.branchId})
                AND (:#{#searchCriteria.hasStatusEmpty()} = TRUE
                    OR a.accountStatus = :#{#searchCriteria.status})
                AND a.role IN :#{#searchCriteria.roles}
            """)
    Page<AccountInfo> pageAll(AccountSearchCriteria searchCriteria, Pageable pageable);
}
