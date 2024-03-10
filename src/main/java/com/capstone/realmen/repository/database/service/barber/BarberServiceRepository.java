package com.capstone.realmen.repository.database.service.barber;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.dto.service.barber.branch.ServiceBranchSearchCriteria;
import com.capstone.realmen.info.service.barber.BarberServiceInfo;

@Repository
public interface BarberServiceRepository extends JpaRepository<BarberServiceEntity, Long> {
    List<BarberServiceEntity> findByServiceCategoryId(Long serviceCategoryId, Pageable pageable);

    @Query("""
            SELECT
                bs.barberServiceId AS barberServiceId,
                bs.serviceCategoryId AS serviceCategoryId,
                brs.branchId AS branchId,
                b.branchName AS branchName,
                sc.serviceCategoryName AS serviceCategoryName,
                bs.barberServiceName AS barberServiceName,
                bs.barberServicePrice AS barberServicePrice,
                bs.thumbnail AS thumbnail
            FROM BarberServiceEntity bs
            INNER JOIN ServiceCategoryEntity sc ON bs.serviceCategoryId = sc.serviceCategoryId
            LEFT JOIN BranchServiceEntity brs ON bs.barberServiceId = brs.barberServiceId
            LEFT JOIN BranchEntity b ON brs.branchId = b.branchId
            WHERE bs.serviceCategoryId = :serviceCategoryId
                AND (:#{#searchCriteria.hasSearchEmpty()} = TRUE
                    OR LOWER(bs.barberServiceName) LIKE %:#{#searchCriteria.search()}%)
                AND (:#{#searchCriteria.hasPriceRangeEmpty()} = TRUE
                    OR bs.barberServicePrice BETWEEN :#{#searchCriteria.priceFrom()} AND :#{#searchCriteria.priceTo()})
                AND (:#{#searchCriteria.hasBranchIdEmpty()} = TRUE
                    OR brs.branchId = :#{#searchCriteria.branchId()})
            """)
    Page<BarberServiceInfo> pageByServiceCategoryId(Long serviceCategoryId,
            BarberServiceSearchCriteria searchCriteria, Pageable pageable);

    @Query("""
            SELECT
                bs.barberServiceId AS barberServiceId,
                bs.serviceCategoryId AS serviceCategoryId,
                brs.branchId AS branchId,
                b.branchName AS branchName,
                sc.serviceCategoryName AS serviceCategoryName,
                bs.barberServiceName AS barberServiceName,
                bs.barberServicePrice AS barberServicePrice,
                bs.thumbnail AS thumbnail
            FROM BarberServiceEntity bs
            INNER JOIN ServiceCategoryEntity sc ON bs.serviceCategoryId = sc.serviceCategoryId
            LEFT JOIN BranchServiceEntity brs ON bs.barberServiceId = brs.barberServiceId
            LEFT JOIN BranchEntity b ON brs.branchId = b.branchId
            WHERE bs.barberServiceId = :barberServiceId
                    """)
    Optional<BarberServiceInfo> findInfoById(Long barberServiceId);

    @Query("""
            SELECT
                bs.barberServiceId AS barberServiceId,
                bs.barberServiceName AS barberServiceName,
                bs.barberServicePrice AS barberServicePrice
            FROM BarberServiceEntity bs
            WHERE :#{#searchCriteria.hasSearchEmpty()} = TRUE OR LOWER(bs.barberServiceName) = :#{#searchCriteria.search()}
                """)
    List<BarberServiceInfo> findAllInfo(BarberServiceSearchCriteria searchCriteria, Pageable pageable);

    @Query("""
            SELECT bs
            FROM BarberServiceEntity bs
            INNER JOIN ComboServiceEntity cs ON bs.barberServiceId = cs.barberServiceId
            WHERE cs.comboId = :comboId
            """)
    List<BarberServiceEntity> findAllByComboId(Long comboId);

    @Query("""
            SELECT
                bs.barberServiceId AS barberServiceId,
                b.branchId AS branchId,
                b.branchName AS branchName,
                b.branchThumbnail AS branchThumbnail,
                brs.branchServicePrice AS branchServicePrice
            FROM BarberServiceEntity bs
            INNER JOIN BranchServiceEntity brs ON bs.barberServiceId = brs.barberServiceId
            INNER JOIN BranchEntity b ON brs.branchId = b.branchId
            WHERE bs.barberServiceId = :barberServiceId
                AND (:#{#searchCriteria.hasSearchEmpty()} = TRUE
                    OR LOWER(b.branchName) LIKE %:#{#searchCriteria.search()}%
                    OR LOWER(b.branchStreet) LIKE %:#{#searchCriteria.search()}%
                    OR LOWER(b.branchWard) LIKE %:#{#searchCriteria.search()}%
                    OR LOWER(b.branchDistrict) LIKE %:#{#searchCriteria.search()}%
                    OR LOWER(b.branchProvince) LIKE %:#{#searchCriteria.search()}%)
                AND (:#{#searchCriteria.hasPriceRangeEmpty()} = TRUE
                    OR brs.branchServicePrice BETWEEN :#{#searchCriteria.priceFrom()}
                        AND :#{#searchCriteria.priceTo()})
            """)
    Page<BarberServiceInfo> pageServiceBranch(Long barberServiceId, ServiceBranchSearchCriteria searchCriteria, Pageable pageable);
}
