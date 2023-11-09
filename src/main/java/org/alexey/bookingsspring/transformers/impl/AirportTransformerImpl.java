package org.alexey.bookingsspring.transformers.impl;

import org.alexey.bookingsspring.core.dto.AirportDto;
import org.alexey.bookingsspring.core.entity.Airport;
import org.alexey.bookingsspring.transformers.AirportTransformer;
import org.springframework.stereotype.Component;

@Component
public class AirportTransformerImpl implements AirportTransformer {
    @Override
    public AirportDto transformDtoFromEntity(Airport airport) {
        return new AirportDto(
                airport.getAirport_code(),
                airport.getAirport_name(),
                airport.getCity(),
                airport.getCoordinates(),
                airport.getTimezone());
    }
}