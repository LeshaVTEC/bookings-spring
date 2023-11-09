package org.alexey.bookingsspring.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "bookings", name="flights")
public class Flight {
    @Id
    @Column(name = "flight_id")
    private Integer flight_id;
    @Column(name = "flight_no")
    private String flight_no;
    @Column(name = "scheduled_departure")
    private LocalDateTime scheduled_departure;
    @Column(name = "scheduled_arrival")
    private LocalDateTime scheduled_arrival;
    @Column(name = "departure_airport")
    private String departure_airport;
    @Column(name = "arrival_airport")
    private String arrival_airport;
    @Column(name = "status")
    private String status;
    @Column(name = "aircraft_code")
    private String aircraft_code;
    @Column(name = "actual_departure")
    private LocalDateTime actual_departure;
    @Column(name = "actual_arrival")
    private LocalDateTime actual_arrival;
}
