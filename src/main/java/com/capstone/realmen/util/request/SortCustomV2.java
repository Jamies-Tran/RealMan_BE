package com.capstone.realmen.util.request;

import java.util.Comparator;
import java.util.List;

import com.capstone.realmen.controller.error.exceptions.ResourceInvalidException;
import com.capstone.realmen.dto.branch.Branch;

public record SortCustomV2() {
    public static List<Branch> sortList(List<Branch> existList, String sorter) {
        String sorters[] = sorter.split("_");
        switch (sorters[0]) {
            case "distance":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::distance))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::distance).reversed())
                                .toList();

                }
                break;
            case "branchName":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchName))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchName).reversed())
                                .toList();
                }
                break;
            case "branchAddress":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchAddress))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchAddress).reversed())
                                .toList();
                }
                break;
            case "branchStreet":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchStreet))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchStreet).reversed())
                                .toList();
                }
                break;
            case "branchWard":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchWard))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchWard).reversed())
                                .toList();
                }
                break;
            case "branchDistrict":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchDistrict))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchDistrict).reversed())
                                .toList();
                }
                break;
            case "branchProvince":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchProvince))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::branchProvince).reversed())
                                .toList();
                }
                break;
            case "createdAt":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::createdAt))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::createdAt).reversed())
                                .toList();
                }
                break;
            case "updatedAt":
                switch (sorters[1]) {
                    case "asc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::updatedAt))
                                .toList();
                    case "desc":
                        return existList.stream()
                                .sorted(Comparator.comparing(Branch::updatedAt).reversed())
                                .toList();
                }
                break;
            default:
                return existList.stream()
                        .sorted(Comparator.comparing(Branch::updatedAt).reversed())
                        .toList();

        }
        throw new ResourceInvalidException();
    }
}
