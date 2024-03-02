package com.capstone.realmen.controller.web.service.barber;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelRequestMapping;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelResponseMapper;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.service.service.barber.BarberServiceUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceController implements BarberServiceAPI {
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceModelResponseMapper responseMapper;
    @NonNull
    private final BarberServiceModelRequestMapping requestMapping;

    @Override
    public ValueResponse<BarberServiceResponse> findById(Long barberServiceId) {
        BarberService foundBarberService = barberServiceUseCaseService.findById(barberServiceId);
        return new ValueResponse<>(responseMapper.toModel(foundBarberService));
    }

    @Override
    public void update(Long barberServiceId, @Valid BarberServiceRequest barberServiceRequest) {
        barberServiceUseCaseService.update(barberServiceId, requestMapping.toDto(barberServiceRequest));
    }

    @Override
    public void delete(Long barberServiceId) {
        barberServiceUseCaseService.delete(barberServiceId);
    }

}
