package org.alexey.bookingsspring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightFilter {
    private LocalDate scheduledDeparture;
    private LocalDate scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;
}
