package org.alexey.bookingsspring.repository;

import org.alexey.bookingsspring.core.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {
}
