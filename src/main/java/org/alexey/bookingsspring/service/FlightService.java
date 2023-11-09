package org.alexey.bookingsspring.service;

import lombok.NoArgsConstructor;
import org.alexey.bookingsspring.core.dto.FlightDto;
import org.alexey.bookingsspring.core.dto.FlightFilter;
import org.alexey.bookingsspring.core.entity.Flight;
import org.alexey.bookingsspring.repository.FlightRepository;
import org.alexey.bookingsspring.transformers.FlightTransformer;
import org.alexey.bookingsspring.transformers.impl.FlightTransformerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightTransformer flightTransformer;

    public FlightService(FlightRepository flightRepository, FlightTransformerImpl flightTransformer) {
        this.flightRepository = flightRepository;
        this.flightTransformer = flightTransformer;
    }

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Page<FlightDto> getFlightsWithFilter(FlightFilter filter, Pageable pageable) {
        Page<Flight> entityPage = flightRepository.getFlightsWithFilters(filter, pageable);
        List<FlightDto> DtoList = entityPage.stream()
                .map(it -> flightTransformer.transformDtoFromEntity(it))
                .toList();
        return new PageImpl<FlightDto>(DtoList, entityPage.getPageable(), entityPage.getTotalElements());

    }
}
