package org.example.domain;

import javax.persistence.Entity;

@Entity
public class EarthMover extends Equipment
{
  EarthMover()
  {
    super();
  }

  public EarthMover(final String serialNumber, final String make, final String model)
  {
    super(serialNumber, make, model);
  }
}
