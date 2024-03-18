package com.capstone.realmen.repository.database.branch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.branch.BranchSearchCriteria;
import com.capstone.realmen.info.branch.BranchInfo;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {
    @Query("""
            SELECT
                b.branchId AS branchId,
                b.branchName AS branchName,
                b.branchThumbnail AS branchThumbnail,
                CONCAT(b.branchStreet,',',b.branchWard,',',b.branchDistrict,',',b.branchProvince) AS branchAddress,
                b.branchStreet AS branchStreet,
                b.branchWard AS branchWard,
                b.branchDistrict AS branchDistrict,
                b.branchProvince AS branchProvince,
                b.latitude AS latitude,
                b.longitude AS longitude,
                b.open AS open,
                b.close AS close,
                b.createdAt AS createdAt,
                b.updatedAt AS updatedAt
            FROM BranchEntity b
            WHERE :#{#searchCriteria.hasSearchEmpty()} = TRUE
                OR LOWER(b.branchName) LIKE %:#{#searchCriteria.search()}%
                OR LOWER(b.branchDistrict) LIKE %:#{#searchCriteria.search()}%
                OR LOWER(b.branchWard) LIKE %:#{#searchCriteria.search()}%
                OR LOWER(b.branchProvince) LIKE %:#{#searchCriteria.search()}%
            """)
    Page<BranchInfo> pageBranches(BranchSearchCriteria searchCriteria, Pageable pageable);
}
