package org.alexey.bookingsspring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AircraftDto {

    private String aircraftCode;
    private String model;
    private Integer range;
}
