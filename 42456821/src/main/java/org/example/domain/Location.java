package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Location()
  {
    super();
  }

  public Location(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
