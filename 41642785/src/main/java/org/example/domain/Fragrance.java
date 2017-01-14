package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fragrance")
public class Fragrance extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Fragrance()
  {
    super();
  }

  public Fragrance(final String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
