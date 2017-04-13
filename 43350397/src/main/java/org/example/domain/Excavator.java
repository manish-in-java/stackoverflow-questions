package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Excavator extends Equipment
{
  Excavator()
  {
    super();
  }

  public Excavator(final String serialNumber, final String make, final String model)
  {
    super(serialNumber, make, model);
  }
}
