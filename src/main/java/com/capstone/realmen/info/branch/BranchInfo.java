package com.capstone.realmen.info.branch;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface BranchInfo {
    void setBranchId(Long branchId);

    void setBranchName(String branchName);

    void setBranchThumbnail(String branchThumbnail);

    void setBranchAddress(String branchAddress);

    void setBranchStreet(String branchStreet);

    void setBranchWard(String branchWard);

    void setBranchDistrict(String branchDistrict);

    void setBranchProvince(String branchProvince);

    void setLatitude(Double latitude);

    void setLongitude(Double longitude);

    void setOpen(LocalTime open);

    void setClose(LocalTime close);

    void setCreatedAt(LocalDateTime createdAt);

    void setUpdatedAt(LocalDateTime updatedAt);

    Long getBranchId();

    String getBranchName();

    String getBranchThumbnail();

    String getBranchAddress();

    String getBranchStreet();

    String getBranchWard();

    String getBranchDistrict();

    String getBranchProvince();

    Double getLatitude();

    Double getLongitude();

    LocalTime getOpen();

    LocalTime getClose();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();
}
