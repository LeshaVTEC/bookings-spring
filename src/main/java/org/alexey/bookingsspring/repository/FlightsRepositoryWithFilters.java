package org.alexey.bookingsspring.repository;

import org.alexey.bookingsspring.core.dto.FlightFilter;
import org.alexey.bookingsspring.core.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightsRepositoryWithFilters {
    Page<Flight> getFlightsWithFilters(Pageable pageable);
    Page<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable);
}
