package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
public class Location extends Model
{
  @Column(name = "latitude", nullable = false, precision = 18, scale = 15, updatable = false)
  private BigDecimal latitude;

  @Column(name = "longitude", nullable = false, precision = 18, scale = 15, updatable = false)
  private BigDecimal longitude;

  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Location()
  {
    super();
  }

  public Location(final String name, final BigDecimal latitude, final BigDecimal longitude)
  {
    this();

    this.latitude = latitude;
    this.longitude = longitude;
    this.name = name;
  }

  public Location(final String name, final double latitude, final double longitude)
  {
    this(name, new BigDecimal(latitude), new BigDecimal(longitude));
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
}
