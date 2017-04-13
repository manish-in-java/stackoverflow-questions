package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Crane extends Equipment
{
  Crane()
  {
    super();
  }

  public Crane(final String serialNumber, final String make, final String model)
  {
    super(serialNumber, make, model);
  }
}
