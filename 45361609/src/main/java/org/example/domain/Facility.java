package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Facility extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  @Column(length = 10, name = "state", nullable = false)
  private String state;

  Facility()
  {
    super();
  }

  public Facility(final String name, final String state)
  {
    this();

    this.name = name;
    this.state = state;
  }

  public String getName()
  {
    return name;
  }

  public String getState()
  {
    return state;
  }
}
