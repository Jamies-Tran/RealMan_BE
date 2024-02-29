package com.capstone.realmen.controller.mobile.service.barber;

import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponse;
import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponseModelMapper;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.service.service.barber.BarberServiceUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceMobController implements BarberServiceMobAPI{
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceMobResponseModelMapper responseMapper;

    @Override
    public ValueResponse<BarberServiceMobResponse> findById(Long barberServiceId) {
        BarberService foundBarberService = barberServiceUseCaseService.findById(barberServiceId);
        return new ValueResponse<>(responseMapper.toModel(foundBarberService));
    }


}
