package org.alexey.bookingsspring.service;

import lombok.NoArgsConstructor;
import org.alexey.bookingsspring.core.dto.AirportDto;
import org.alexey.bookingsspring.repository.AirportRepository;
import org.alexey.bookingsspring.transformers.AirportTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private AirportTransformer airportTransformer;

    public AirportService(AirportRepository airportRepository, AirportTransformer airportTransformer) {
        this.airportRepository = airportRepository;
        this.airportTransformer = airportTransformer;
    }

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportDto> findAllAirports(){

        return airportRepository.findAll()
                .stream()
                .map(it -> airportTransformer.transformDtoFromEntity(it))
                .collect(Collectors.toList());
    }
}
