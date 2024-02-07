package com.capstone.realmen.util.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public record PageRequestCustom(PageRequest pageRequest) {
    public static PageRequestCustom of(Integer current, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(current - 1, pageSize);
        return new PageRequestCustom(pageRequest);
    }

    public static PageRequestCustom of(Integer current, Integer pageSize, String sorter) {
        PageRequest pageRequest = PageRequest.of(current - 1, pageSize, Sort.by(sorter));
        return new PageRequestCustom(pageRequest);
    }

    public Integer current() {
        return pageRequest.getPageNumber() + 1;
    }
}
