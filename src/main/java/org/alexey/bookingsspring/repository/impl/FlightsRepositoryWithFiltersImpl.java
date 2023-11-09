package org.alexey.bookingsspring.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.alexey.bookingsspring.core.dto.FlightFilter;
import org.alexey.bookingsspring.core.entity.Flight;
import org.alexey.bookingsspring.repository.FlightsRepositoryWithFilters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class FlightsRepositoryWithFiltersImpl implements FlightsRepositoryWithFilters {

    private final EntityManagerFactory entityManagerFactory;

    public FlightsRepositoryWithFiltersImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Page<Flight> getFlightsWithFilters(Pageable pageable) {
        return getFlightsWithFilters(null, pageable);
    }

    @Override
    public Page<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);

        Predicate finalPredicate = buildPredicate(filter, criteriaBuilder, root);

        query.where(finalPredicate);

        List<Flight> flights = entityManager.createQuery(query)
                .setFirstResult(pageable.getPageNumber())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        return new PageImpl<Flight>(flights, pageable, -1);
    }

    private Predicate buildPredicate(FlightFilter filter, CriteriaBuilder criteriaBuilder, Root<Flight> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getScheduledDeparture() != null) {
            Predicate scheduledDeparturePredicateStart = criteriaBuilder
                    .greaterThan(root.get("scheduled_departure"), filter.getScheduledDeparture());
            Predicate scheduledDeparturePredicateFinish = criteriaBuilder
                    .lessThan(root.get("scheduled_departure"), filter.getScheduledDeparture().plusDays(1));
            predicates.add(scheduledDeparturePredicateStart);
            predicates.add(scheduledDeparturePredicateFinish);
        }
        if (filter.getScheduledArrival() != null) {
            Predicate scheduledArrivalPredicateStart = criteriaBuilder
                    .greaterThan(root.get("scheduled_arrival"), filter.getScheduledArrival());
            Predicate scheduledArrivalPredicateFinish = criteriaBuilder
                    .lessThan(root.get("scheduled_arrival"), filter.getScheduledArrival().plusDays(1));
            predicates.add(scheduledArrivalPredicateStart);
            predicates.add(scheduledArrivalPredicateFinish);
        }
        if (filter.getDepartureAirport() != null) {
            Predicate departureAirportPredicate = criteriaBuilder
                    .equal(root.get("departure_airport"), filter.getDepartureAirport());
            predicates.add(departureAirportPredicate);
        }
        if (filter.getArrivalAirport() != null) {
            Predicate arrivalAirportPredicate = criteriaBuilder
                    .equal(root.get("arrival_airport"), filter.getArrivalAirport());
            predicates.add(arrivalAirportPredicate);
        }
        if (filter.getStatus() != null) {
            Predicate statusPredicate = criteriaBuilder
                    .equal(root.get("status"), filter.getStatus());
            predicates.add(statusPredicate);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
