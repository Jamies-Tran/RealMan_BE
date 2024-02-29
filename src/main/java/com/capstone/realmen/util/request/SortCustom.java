package com.capstone.realmen.util.request;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import lombok.Builder;

@Builder
public record SortCustom(Sort sortBy) {
    public static Sort of(String sorter) {
        Sort sortBy = Sort.by(Order.desc("updatedAt"));
        String[] sorters = sorter.split("_");
        if (sorters.length == 2) {
            if (sorters[1].equalsIgnoreCase("asc")) {
                sortBy = Sort.by(Order.asc(sorters[0]));
            } else if (sorters[1].equalsIgnoreCase("desc")) {
                sortBy = Sort.by(Order.desc(sorters[0]));
            }
        } 
        return sortBy;
    }
}
