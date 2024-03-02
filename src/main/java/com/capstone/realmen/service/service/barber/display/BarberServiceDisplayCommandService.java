package com.capstone.realmen.service.service.barber.display;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;
import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplayMapper;
import com.capstone.realmen.repository.database.service.barber.display.BarberServiceDisplayEntity;
import com.capstone.realmen.repository.database.service.barber.display.BarberServiceDisplayRepository;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceDisplayCommandService {
        @NonNull
        private final BarberServiceDisplayRepository barberServiceDisplayRepository;
        @NonNull
        private final BarberServiceDisplayMapper dtoMapper;
        @NonNull
        private final RequestContext requestContext;

        public void saveAll(Long barberServiceId,
                        List<BarberServiceDisplay> displays) {
                List<BarberServiceDisplayEntity> saveList = displays.stream()
                                .map(display -> dtoMapper.create(display, barberServiceId,
                                                Auditable.of(requestContext.getAccountId().toString())))
                                .toList();
                barberServiceDisplayRepository.saveAll(saveList);
        }

        public void deleteAll(Long barberServiceId) {
                barberServiceDisplayRepository.deleteAllByBarberServiceId(barberServiceId);
        }

        public void deleteAll(List<Long> barberServiceIds) {
                barberServiceDisplayRepository.deleteAllById(barberServiceIds);
        }
}
