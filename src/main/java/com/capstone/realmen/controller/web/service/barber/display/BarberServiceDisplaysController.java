package com.capstone.realmen.controller.web.service.barber.display;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.service.service.barber.display.BarberServiceDisplayUseCaseService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceDisplaysController implements BarberServiceDisplaysAPI{
    @NonNull
    private final BarberServiceDisplayUseCaseService displayUseCaseService;

    @Override
    public void deleteAll(List<Long> barberServiceIds) {
        displayUseCaseService.deleteAll(barberServiceIds);
    }
}
