package com.capstone.realmen.repository.database.branch.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.info.branch.service.BranchServiceInfo;

@Repository
public interface BranchServiceRepository extends JpaRepository<BranchServiceEntity, Long> {
    @Query("""
            SELECT
                brs.branchServiceId AS branchServiceId,
                b.branchId AS branchId,
                bs.barberServiceId AS barberServiceId,
                b.branchName AS branchName,
                b.branchThumbnail AS branchThumbnail,
                b.branchStreet AS branchStreet,
                b.branchWard AS branchWard,
                b.branchDistrict AS branchDistrict,
                b.branchProvince AS branchProvince,
                brs.branchServicePrice AS branchServicePrice,
                bs.barberServiceName AS barberServiceName,
                bs.barberServiceThumbnail AS barberServiceThumbnail,
                bs.barberServicePrice AS barberServicePrice
            FROM BranchServiceEntity brs
            INNER JOIN BranchEntity b ON brs.branchId = b.branchId
            INNER JOIN BarberServiceEntity bs ON brs.barberServiceId = bs.barberServiceId
            WHERE brs.branchServiceId = :branchServiceId
            """)
    Optional<BranchServiceInfo> findInfoById(Long branchServiceId);
}
