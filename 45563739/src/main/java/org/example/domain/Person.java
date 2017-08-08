package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person extends Model
{
  @JoinColumn(name = "house_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private House house;

  Person()
  {
    super();
  }

  public Person(final House house)
  {
    this();

    this.house = house;
  }
}
