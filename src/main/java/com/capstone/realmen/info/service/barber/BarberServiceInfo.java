package com.capstone.realmen.info.service.barber;

public interface BarberServiceInfo {
    void setBarberServiceId(Long barberServiceId);

    void setBranchServiceId(Long branchServiceId);

    void setServiceCategoryId(Long serviceCategoryId);

    void setBranchId(Long branchId);

    void setBranchName(String branchName);

    void setBranchThumbnail(String branchThumbnail);

    void setBranchServicePrice(Long branchServicePrice);

    void setServiceCategoryName(String serviceCategoryName);

    void setBarberServiceName(String barberServiceName);

    void setBarberServicePrice(Long barberServicePrice);

    void setBarberServiceThumbnail(String barberServiceThumbnail);

    Long getBarberServiceId();

    Long getBranchServiceId();

    Long getServiceCategoryId();

    Long getBranchId();

    String getBranchName();

    String getBranchThumbnail();

    Long getBranchServicePrice();

    String getServiceCategoryName();

    String getBarberServiceName();

    Long getBarberServicePrice();

    String getBarberServiceThumbnail();
}
