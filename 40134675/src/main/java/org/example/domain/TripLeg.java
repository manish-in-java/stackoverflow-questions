package org.example.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trip_leg")
public class TripLeg extends Model implements Comparable<TripLeg>
{
  @Column(name = "departure", nullable = false, updatable = false)
  private Date     departure;
  @JoinColumn(name = "destination_id", nullable = false, updatable = false)
  @ManyToOne
  private Location destination;
  @JoinColumn(name = "origin_id", nullable = false, updatable = false)
  @ManyToOne
  private Location origin;
  @JoinColumn(name = "trip_id", nullable = false, updatable = false)
  @ManyToOne
  private Trip     trip;

  TripLeg()
  {
    super();
  }

  TripLeg(final Trip trip, final Location origin, final Location destination, final Date departure)
  {
    this();

    this.departure = departure;
    this.destination = destination;
    this.origin = origin;
    this.trip = trip;
  }

  public Date getDeparture()
  {
    return departure;
  }

  public Location getDestination()
  {
    return destination;
  }

  public Location getOrigin()
  {
    return origin;
  }

  public Trip getTrip()
  {
    return trip;
  }

  public int compareTo(final TripLeg that)
  {
    if (this == that)
    {
      return 0;
    }

    return that.getDeparture().compareTo(this.getDeparture());
  }
}
