package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle
{
  Motorcycle()
  {
    super();
  }

  public Motorcycle(final Garage garage)
  {
    super(garage);
  }
}
