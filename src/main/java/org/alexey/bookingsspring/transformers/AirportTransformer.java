package org.alexey.bookingsspring.transformers;

import org.alexey.bookingsspring.core.dto.AirportDto;
import org.alexey.bookingsspring.core.entity.Airport;

public interface AirportTransformer {
    public AirportDto transformDtoFromEntity(Airport airport);
}