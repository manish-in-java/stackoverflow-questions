package org.example.data;

import org.example.domain.Location;
import org.example.domain.Measurement;

import java.math.BigDecimal;

public interface ExtendedMeasurementRepository<T extends Measurement>
{
  BigDecimal findMaximumValue(Location location);

  BigDecimal findMinimumValue(Location location);
}
