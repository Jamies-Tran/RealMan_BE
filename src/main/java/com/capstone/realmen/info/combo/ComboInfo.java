package com.capstone.realmen.info.combo;

public interface ComboInfo {
    void setComboId(Long comboId);

    void setBranchId(Long branchId);

    void setComboName(String comboName);

    void setComboPrice(Long comboPrice);

    Long getComboId();

    Long getBranchId();

    String getComboName();

    Long getComboPrice();

}
