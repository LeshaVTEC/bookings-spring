package org.alexey.bookingsspring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportDto {

    private String airport_code;
    private String airport_name;
    private String city;
    private String coordinates;
    private String timezone;
}
