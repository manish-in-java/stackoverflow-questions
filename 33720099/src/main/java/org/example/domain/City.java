package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "city")
public class City
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @JoinColumn(name = "country_id")
  @ManyToOne
  private Country country;

  @Column(name = "latitude")
  private BigDecimal latitude;

  @Column(name = "longitude")
  private BigDecimal longitude;

  @Column(name = "name")
  private String name;

  @Column(name = "population")
  private Long population;

  City()
  {
    super();
  }

  public City(final Country country, final String name, final BigDecimal latitude, final BigDecimal longitude, final Long population)
  {
    this.country = country;
    this.latitude = latitude;
    this.longitude = longitude;
    this.name = name;
    this.population = population;

    country.addCity(this);
  }

  public Long getID()
  {
    return id;
  }

  public BigDecimal getLatitude()
  {
    return latitude;
  }

  public BigDecimal getLongitude()
  {
    return longitude;
  }

  public String getName()
  {
    return name;
  }

  public Long getPopulation()
  {
    return population;
  }
}
