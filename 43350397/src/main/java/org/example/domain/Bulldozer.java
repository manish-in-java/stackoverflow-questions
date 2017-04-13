package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Bulldozer extends Equipment
{
  Bulldozer()
  {
    super();
  }

  public Bulldozer(final String serialNumber, final String make, final String model)
  {
    super(serialNumber, make, model);
  }
}
