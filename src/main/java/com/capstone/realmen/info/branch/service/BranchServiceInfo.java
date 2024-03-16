package com.capstone.realmen.info.branch.service;

public interface BranchServiceInfo {
    void setBranchServiceId(Long branchServiceId);
    
    void setBranchId(Long branchId);

    void setBarberServiceId(Long barberServiceId);

    void setBranchServicePrice(Long branchServicePrice);

    void setBranchName(String branchName);

    void setBranchThumbnail(String branchThumbnail);

    void setBranchStreet(String branchStreet);

    void setBranchWard(String branchWard);

    void setBranchDistrict(String branchDistrict);

    void setBranchProvince(String branchProvince);

    void setBarberServicePrice(Long barberServicePrice);

    void setBarberServiceName(String barberServiceName);

    void setBarberServiceThumbnail(String barberServiceThumbnail);

    Long getBranchServiceId();
    
    Long getBranchId();

    Long getBarberServiceId();

    Long getBranchServicePrice();

    String getBranchName();

    String getBranchThumbnail();

    String getBranchStreet();

    String getBranchWard();

    String getBranchDistrict();

    String getBranchProvince();

    Long getBarberServicePrice();

    String getBarberServiceName();

    String getBarberServiceThumbnail();
}
