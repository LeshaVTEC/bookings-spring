package org.alexey.bookingsspring.service;

import lombok.NoArgsConstructor;
import org.alexey.bookingsspring.core.dto.AircraftDto;
import org.alexey.bookingsspring.repository.AircraftRepository;
import org.alexey.bookingsspring.transformers.impl.AircraftTransformerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private AircraftTransformerImpl aircraftTransformer;

    public AircraftService(AircraftRepository aircraftRepository, AircraftTransformerImpl aircraftTransformer) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftTransformer = aircraftTransformer;
    }

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<AircraftDto> findAllAircrafts(){

        return aircraftRepository.findAll()
                .stream()
                .map(it -> aircraftTransformer.transformDtoFromEntity(it))
                .collect(Collectors.toList());
    }
}
