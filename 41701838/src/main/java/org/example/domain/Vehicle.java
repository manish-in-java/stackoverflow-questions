package org.example.domain;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Vehicle extends Model
{
  @JoinColumn(name = "garage_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Garage garage;

  Vehicle()
  {
    super();
  }

  protected Vehicle(final Garage garage)
  {
    this();

    this.garage = garage;
  }

  public Garage getGarage()
  {
    return garage;
  }
}
