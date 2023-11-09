package org.alexey.bookingsspring.controller;

import org.alexey.bookingsspring.core.dto.AirportDto;
import org.alexey.bookingsspring.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDto> getAllAirports(){
        return airportService.findAllAirports();
    }
}
