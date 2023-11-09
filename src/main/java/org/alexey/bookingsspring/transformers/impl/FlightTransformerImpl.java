package org.alexey.bookingsspring.transformers.impl;

import org.alexey.bookingsspring.core.dto.FlightDto;
import org.alexey.bookingsspring.core.entity.Flight;
import org.alexey.bookingsspring.transformers.FlightTransformer;
import org.springframework.stereotype.Component;

@Component
public class FlightTransformerImpl implements FlightTransformer {

    @Override
    public FlightDto transformDtoFromEntity(Flight flight) {
        return new FlightDto(
                flight.getFlight_id(),
                flight.getFlight_no(),
                flight.getScheduled_departure(),
                flight.getScheduled_arrival(),
                flight.getDeparture_airport(),
                flight.getArrival_airport(),
                flight.getStatus(),
                flight.getAircraft_code(),
                flight.getActual_departure(),
                flight.getActual_arrival()
        );
    }
}