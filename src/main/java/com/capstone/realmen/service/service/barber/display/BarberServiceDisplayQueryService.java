package com.capstone.realmen.service.service.barber.display;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;
import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplayMapper;
import com.capstone.realmen.repository.database.service.barber.display.BarberServiceDisplayRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceDisplayQueryService {
    @NonNull
    private final BarberServiceDisplayRepository barberServiceDisplayRepository;
    @NonNull
    private final BarberServiceDisplayMapper dtoMapper;

    public List<BarberServiceDisplay> findAllByBarberServiceId(Long barberServiceId) {
        List<BarberServiceDisplay> displays = barberServiceDisplayRepository.findAllByBarberServiceId(barberServiceId)
                .stream().map(dtoMapper::toDto).toList();
        return displays;
    }
}
