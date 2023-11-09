package org.alexey.bookingsspring.controller;

import org.alexey.bookingsspring.core.dto.AircraftDto;
import org.alexey.bookingsspring.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/aircrafts")
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<AircraftDto> getAllAircrafts(){
            return aircraftService.findAllAircrafts();

    }
}
