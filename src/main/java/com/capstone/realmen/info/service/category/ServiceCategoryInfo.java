package com.capstone.realmen.info.service.category;

public interface ServiceCategoryInfo {
    void setServiceCategoryId(Long serviceCategoryId);

    void setServiceCategoryCode(String serviceCategoryCode);

    void setServiceCategoryName(String serviceCategoryName);

    Long getServiceCategoryId();

    String getServiceCategoryCode();

    String getServiceCategoryName();
}
