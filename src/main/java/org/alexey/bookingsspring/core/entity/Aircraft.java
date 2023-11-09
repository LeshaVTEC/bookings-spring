package org.alexey.bookingsspring.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "bookings", name="aircrafts_data")
public class Aircraft {
    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "model")
    private String model;
    @Column(name = "range")
    private Integer range;
}
