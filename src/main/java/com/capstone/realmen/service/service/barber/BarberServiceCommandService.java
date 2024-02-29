package com.capstone.realmen.service.service.barber;

import org.springframework.stereotype.Service;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.BarberServiceMapper;
import com.capstone.realmen.repository.database.service.barber.BarberServiceEntity;
import com.capstone.realmen.repository.database.service.barber.BarberServiceRepository;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceCommandService {
    @NonNull
    private final BarberServiceRepository barberServiceRepository;
    @NonNull
    private final BarberServiceMapper barberServiceMapper;
    @NonNull
    private final RequestContext requestContext;

    public void save(BarberService barberService) {
        BarberServiceEntity saveBarberService = barberServiceMapper.create(barberService,
                Auditable.of(requestContext.getAccountId().toString()));
        barberServiceRepository.save(saveBarberService);
    }
}
