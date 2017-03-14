package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  City()
  {
    super();
  }

  public City(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
