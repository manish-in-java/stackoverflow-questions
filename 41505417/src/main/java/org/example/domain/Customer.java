package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Model
{
  @JoinColumn(name = "city_id", nullable = false)
  @ManyToOne
  private City city;

  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Customer()
  {
    super();
  }

  public Customer(final City city, final String name)
  {
    this();

    this.city = city;
    this.name = name;
  }

  public City getCity()
  {
    return city;
  }

  public String getName()
  {
    return name;
  }
}
