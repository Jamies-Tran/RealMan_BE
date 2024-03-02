package com.capstone.realmen.info.service.barber;

public interface BarberServiceInfo {
    void setBarberServiceId(Long barberServiceId);

    void setServiceCategoryId(Long serviceCategoryId);

    void setServiceCategoryName(String serviceCategoryName);

    void setBarberServiceName(String barberServiceName);

    void setBarberServicePrice(Long barberServicePrice);

    void setThumbnail(String thumbnail);

    Long getBarberServiceId();

    Long getServiceCategoryId();

    String getServiceCategoryName();

    String getBarberServiceName();

    Long getBarberServicePrice();

    String getThumbnail();
}
