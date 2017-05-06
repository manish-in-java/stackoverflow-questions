package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Site extends Model
{
  @Column(name = "latitude", nullable = false)
  private String latitude;

  @Column(name = "longitude", nullable = false)
  private String longitude;

  @Column(name = "name", nullable = false)
  private String name;

  Site()
  {
    super();
  }

  public Site(final String name, final String latitude, final String longitude)
  {
    this();

    this.latitude = latitude;
    this.longitude = longitude;
    this.name = name;
  }

  public String getLatitude()
  {
    return latitude;
  }

  public String getLongitude()
  {
    return longitude;
  }

  public String getName()
  {
    return name;
  }
}
