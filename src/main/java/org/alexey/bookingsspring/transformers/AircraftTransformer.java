package org.alexey.bookingsspring.transformers;

import org.alexey.bookingsspring.core.dto.AircraftDto;
import org.alexey.bookingsspring.core.entity.Aircraft;

public interface AircraftTransformer {
    public AircraftDto transformDtoFromEntity(Aircraft aircraft);
}