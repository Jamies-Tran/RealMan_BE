package com.capstone.realmen.info.combo;

public interface ComboInfo {
    void setComboId(Long comboId);

    void setBranchId(Long branchId);

    void setBranchName(String branchName);

    void setComboName(String comboName);

    void setComboPrice(Long comboPrice);

    Long getComboId();

    Long getBranchId();

    String getBranchName();

    String getComboName();

    Long getComboPrice();

}
