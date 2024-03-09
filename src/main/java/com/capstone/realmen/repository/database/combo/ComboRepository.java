package com.capstone.realmen.repository.database.combo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.info.combo.ComboInfo;

@Repository
public interface ComboRepository extends JpaRepository<ComboEntity, Long> {
    @Query("""
            SELECT
                c.comboId AS comboId,
                c.branchId AS branchId,
                b.branchName AS branchName,
                c.comboName AS comboName,
                c.comboPrice AS comboPrice
            FROM ComboEntity c
            LEFT JOIN BranchEntity b ON c.branchId = b.branchId
            WHERE c.comboId = :comboId
            """)
    Optional<ComboInfo> findInfoById(Long comboId);

    @Query("""
            SELECT
                c.comboId AS comboId,
                c.branchId AS branchId,
                b.branchName AS branchName,
                c.comboName AS comboName,
                c.comboPrice AS comboPrice
            FROM ComboEntity c
            LEFT JOIN BranchEntity b ON c.branchId = b.branchId
            WHERE (:#{#searchCriteria.hasPriceRangeEmpty()} = TRUE OR
                    c.comboPrice BETWEEN :#{#searchCriteria.priceFrom()} AND :#{#searchCriteria.priceTo()})
                AND (:#{#searchCriteria.hasSearchEmpty()} = TRUE OR
                    LOWER(c.comboName) LIKE %:#{#searchCriteria.search()}%)
                AND (:#{#searchCriteria.hasBranchIdEmpty()} = TRUE OR
                    b.branchId = :#{#searchCriteria.branchId()})
            """)
    Page<ComboInfo> pageAllInfo(ComboSearchCriteria searchCriteria, Pageable pageable);


    @Query("""
            SELECT 
                c.comboId AS comboId,
                c.comboName AS comboName,
                c.comboPrice AS comboPrice
            FROM ComboEntity c
            WHERE (:#{#searchCriteria.hasSearchEmpty()} = TRUE OR
                    LOWER(c.comboName) LIKE %:#{#searchCriteria.search()}%)
                AND (:#{#searchCriteria.hasBranchIdEmpty()} = TRUE OR
                    c.branchId = :#{#searchCriteria.branchId})
            """)
    List<ComboInfo> findAllInfo(ComboSearchCriteria searchCriteria, Pageable pageable);
}
