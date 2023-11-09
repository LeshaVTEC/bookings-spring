package org.alexey.bookingsspring.transformers.impl;

import org.alexey.bookingsspring.core.dto.AircraftDto;
import org.alexey.bookingsspring.core.entity.Aircraft;
import org.alexey.bookingsspring.transformers.AircraftTransformer;
import org.springframework.stereotype.Component;

@Component
public class AircraftTransformerImpl implements AircraftTransformer {
    @Override
    public AircraftDto transformDtoFromEntity(Aircraft aircraft){
        return new AircraftDto(
                aircraft.getAircraftCode(),
                aircraft.getModel(),
                aircraft.getRange()
        );
    }
}