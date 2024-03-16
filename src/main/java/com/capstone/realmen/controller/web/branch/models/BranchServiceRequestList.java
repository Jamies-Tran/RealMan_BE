package com.capstone.realmen.controller.web.branch.models;

import java.util.List;

import lombok.Builder;

@Builder
public record BranchServiceRequestList(List<BranchServiceRequest> requests) {

}
