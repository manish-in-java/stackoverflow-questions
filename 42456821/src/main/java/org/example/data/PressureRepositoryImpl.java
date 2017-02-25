package org.example.data;

import org.example.domain.Pressure;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class PressureRepositoryImpl extends ExtendedMeasurementRepositoryImpl<Pressure>
{
  @Autowired
  public PressureRepositoryImpl(final EntityManager entityManager)
  {
    super(entityManager, Pressure.class);
  }
}
