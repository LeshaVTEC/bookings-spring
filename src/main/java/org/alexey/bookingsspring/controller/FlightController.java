package org.alexey.bookingsspring.controller;

import org.alexey.bookingsspring.core.dto.FlightDto;
import org.alexey.bookingsspring.core.dto.FlightFilter;
import org.alexey.bookingsspring.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public Page<FlightDto> getFlightsWithFilters(@RequestParam(name = "scheduled_departure", required = false) LocalDate scheduledDeparture,
                                                 @RequestParam(name = "scheduled_arrival", required = false) LocalDate scheduledArrival,
                                                 @RequestParam(name = "departure_airport", required = false) String departureAirport,
                                                 @RequestParam(name = "arrival_airport", required = false) String arrivalAirport,
                                                 @RequestParam(name = "status", required = false) String status,
                                                 @RequestParam(name = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "20") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        FlightFilter filter = new FlightFilter(
                scheduledDeparture,
                scheduledArrival,
                departureAirport,
                arrivalAirport,
                status
        );
       return flightService.getFlightsWithFilter(filter, pageable);
    }
}
