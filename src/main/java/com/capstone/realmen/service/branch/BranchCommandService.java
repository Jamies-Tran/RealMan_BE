package com.capstone.realmen.service.branch;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.dto.branch.BranchMapper;
import com.capstone.realmen.repository.database.branch.BranchEntity;
import com.capstone.realmen.repository.database.branch.BranchRepository;
import com.capstone.realmen.repository.feign.location.geo.ForwardGeocodingService;
import com.capstone.realmen.repository.feign.location.geo.models.Address;
import com.capstone.realmen.repository.feign.location.geo.models.AddressComponent;
import com.capstone.realmen.repository.feign.location.geo.models.AddressResponse;
import com.capstone.realmen.repository.feign.location.geo.models.Geometry;
import com.capstone.realmen.repository.feign.location.geo.models.Location;
import com.capstone.realmen.service.branch.display.BranchDisplayCommandService;
import com.capstone.realmen.service.branch.service.BranchServiceCommandService;
import com.capstone.realmen.service.combo.ComboCommandService;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchCommandService {
        @NonNull
        private final BranchRepository branchRepository;
        @NonNull
        private final ForwardGeocodingService geocodingService;
        @NonNull
        private final BranchDisplayCommandService branchDisplayCommandService;
        @NonNull
        private final BranchServiceCommandService branchServiceCommandService;
        @NonNull
        private final ComboCommandService comboCommandService;
        @NonNull
        private final BranchMapper branchMapper;
        @NonNull
        private final RequestContext requestContext;

        public void save(Branch branch) {
                AddressResponse addressResponse = geocodingService.getAddressComponents(branch.branchAddress());
                List<AddressComponent> addressComponents = addressResponse.address().stream()
                                .map(Address::addressComponents)
                                .findAny().get();
                String branchStreet = addressComponents.get(0).addressComponent();
                String branchWard = addressComponents.get(1).addressComponent();
                String branchDistrict = addressComponents.get(2).addressComponent();
                String branchProvince = addressComponents.get(3).addressComponent();
                Double latitude = addressResponse.address().stream().map(Address::geometry).map(Geometry::location)
                                .mapToDouble(Location::latitude).findAny().getAsDouble();
                Double longitude = addressResponse.address().stream().map(Address::geometry).map(Geometry::location)
                                .mapToDouble(Location::longitude).findAny().getAsDouble();
                BranchEntity saveBranch = branchMapper.create(branch, branchStreet, branchWard,
                                branchDistrict, branchProvince, latitude, longitude,
                                Auditable.of(requestContext.getAccountId().toString()));
                BranchEntity savedBranch = branchRepository.save(saveBranch);
                branchDisplayCommandService.saveAll(savedBranch.getBranchId(), branch.branchDisplays());
                if (!branch.barberServiceIds().isEmpty() || Objects.nonNull(branch.barberServiceIds())) {
                        branchServiceCommandService.saveAll(savedBranch.getBranchId(), branch.barberServiceIds());
                }
                if (!branch.comboIds().isEmpty() || Objects.nonNull(branch.comboIds())) {
                        comboCommandService.updateBranch(savedBranch.getBranchId(), branch.comboIds());
                }
        }
}