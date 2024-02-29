package com.capstone.realmen.repository.database.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.realmen.dto.service.category.ServiceCategorySearchCriteria;
import com.capstone.realmen.info.service.category.ServiceCategoryInfo;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategoryEntity, Long> {
    @Query("""
            SELECT
                sc.serviceCategoryId AS serviceCategoryId,
                sc.serviceCategoryCode AS serviceCategoryCode,
                sc.serviceCategoryName AS serviceCategoryName
            FROM ServiceCategoryEntity sc
            WHERE sc.serviceCategoryId = :serviceCategoryId
            """)
    Optional<ServiceCategoryInfo> findInfoById(Long serviceCategoryId);

    @Query("""
            SELECT
                sc.serviceCategoryId AS serviceCategoryId,
                sc.serviceCategoryCode AS serviceCategoryCode,
                sc.serviceCategoryName AS serviceCategoryName
            FROM ServiceCategoryEntity sc
            WHERE :#{#searchCriteria.hasSearchEmpty()} = TRUE 
                OR (LOWER(sc.serviceCategoryCode) LIKE %:#{#searchCriteria.search}%
                    OR LOWER(sc.serviceCategoryName) LIKE %:#{#searchCriteria.search}%)
            """)
    List<ServiceCategoryInfo> findInfos(ServiceCategorySearchCriteria searchCriteria);
}
