package com.capstone.realmen.service.service.barber.display;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceDisplayUseCaseService {
    @NonNull
    private final BarberServiceDisplayCommandService commandService;

    @Transactional
    public void deleteAll(List<Long> barberServiceIds) {
        commandService.deleteAll(barberServiceIds);
    }
}
