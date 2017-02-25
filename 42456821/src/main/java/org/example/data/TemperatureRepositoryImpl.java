package org.example.data;

import org.example.domain.Temperature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class TemperatureRepositoryImpl extends ExtendedMeasurementRepositoryImpl<Temperature>
{
  @Autowired
  public TemperatureRepositoryImpl(final EntityManager entityManager)
  {
    super(entityManager, Temperature.class);
  }
}
