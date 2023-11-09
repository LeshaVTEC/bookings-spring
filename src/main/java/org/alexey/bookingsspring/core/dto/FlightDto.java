package org.alexey.bookingsspring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDto {

    private Integer flight_id;
    private String flight_no;
    private LocalDateTime scheduled_departure;
    private LocalDateTime scheduled_arrival;
    private String departure_airport;
    private String arrival_airport;
    private String status;
    private String aircraft_code;
    private LocalDateTime actual_departure;
    private LocalDateTime actual_arrival;
}
