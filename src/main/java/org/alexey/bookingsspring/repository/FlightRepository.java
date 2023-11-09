package org.alexey.bookingsspring.repository;

import org.alexey.bookingsspring.core.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>, FlightsRepositoryWithFilters {

}
