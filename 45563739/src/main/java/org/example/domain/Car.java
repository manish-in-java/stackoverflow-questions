package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends Model
{
  @JoinColumn(name = "house_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private House house;

  Car()
  {
    super();
  }

  public Car(final House house)
  {
    this();

    this.house = house;
  }
}
