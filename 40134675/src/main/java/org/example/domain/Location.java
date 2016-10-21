package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location extends Model
{
  @Column(length = 6, name = "code", nullable = false)
  private String code;
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Location()
  {
    super();
  }

  public Location(final String code, final String name)
  {
    this();

    this.code = code;
    this.name = name;
  }

  public String getCode()
  {
    return code;
  }

  public String getName()
  {
    return name;
  }
}
