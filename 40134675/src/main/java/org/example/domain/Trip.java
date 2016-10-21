package org.example.domain;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "trip")
public class Trip extends Model
{
  @Column(length = 100, name = "traveler", nullable = false)
  private String             traveler;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip", orphanRemoval = true)
  @SortNatural
  private SortedSet<TripLeg> legs;

  Trip()
  {
    super();
  }

  public Trip(final String traveler)
  {
    this.traveler = traveler;
  }

  public void addLeg(final Location origin, final Location destination, final Date departure)
  {
    if (legs == null)
    {
      legs = new TreeSet<>();
    }

    legs.add(new TripLeg(this, origin, destination, departure));
  }

  public SortedSet<TripLeg> getLegs()
  {
    return legs != null ? Collections.unmodifiableSortedSet(legs) : Collections.emptySortedSet();
  }

  public String getTraveler()
  {
    return traveler;
  }
}
