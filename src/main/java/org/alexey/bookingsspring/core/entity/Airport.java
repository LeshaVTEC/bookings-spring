package org.alexey.bookingsspring.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "bookings", name = "airports_data")
public class Airport {
    @Id
    @Column(name = "airport_code")
    private String airport_code;
    @Column(name = "airport_name")
    private String airport_name;
    @Column(name = "city")
    private String city;
    @Column(name = "coordinates")
    private String coordinates;
    @Column(name = "timezone")
    private String timezone;

}
