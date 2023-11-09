package org.alexey.bookingsspring.transformers;

import org.alexey.bookingsspring.core.dto.FlightDto;
import org.alexey.bookingsspring.core.entity.Flight;

public interface FlightTransformer {

    FlightDto transformDtoFromEntity(Flight flight);
}
