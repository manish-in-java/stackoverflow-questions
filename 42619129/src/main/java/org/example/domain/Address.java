package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends Model
{
  @Column(length = 100, name = "city", nullable = false)
  private String city;

  Address()
  {
    super();
  }

  public Address(final String city)
  {
    this();

    this.city = city;
  }

  public String getCity()
  {
    return city;
  }
}
