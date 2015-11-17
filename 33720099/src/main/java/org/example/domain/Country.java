package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "name")
  private String name;

  @OnDelete(action = OnDeleteAction.CASCADE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", orphanRemoval = true)
  private Set<City> cities;

  @OnDelete(action = OnDeleteAction.CASCADE)
  @OneToMany(mappedBy = "country")
  private Set<CitySummary> citySummaries;

  Country()
  {
    super();
  }

  public Country(final String name)
  {
    this.name = name;
  }

  public Set<City> getCities()
  {
    return cities;
  }

  public Set<CitySummary> getCitySummaries()
  {
    return citySummaries;
  }

  public Long getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  void addCity(final City city)
  {
    if (cities == null)
    {
      cities = new HashSet<>();
    }

    cities.add(city);
  }
}
