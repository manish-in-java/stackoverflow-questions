package org.example.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class Measurement extends Model
{
  @JoinColumn(name = "location_id", nullable = false, updatable = false)
  @ManyToOne
  private Location location;

  @Column(name = "time", nullable = false, updatable = false)
  private Date time;

  @Column(name = "value", nullable = false, updatable = false)
  private BigDecimal value;

  protected Measurement()
  {
    super();
  }

  protected Measurement(final Location location, final Date time, final BigDecimal value)
  {
    this();

    this.location = location;
    this.time = time;
    this.value = value;
  }

  public Location getLocation()
  {
    return location;
  }

  public Date getTime()
  {
    return time;
  }

  public BigDecimal getValue()
  {
    return value;
  }
}
