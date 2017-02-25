package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pressure")
public class Pressure extends Measurement
{
  Pressure()
  {
    super();
  }

  public Pressure(final Location location, final Date time, final BigDecimal value)
  {
    super(location, time, value);
  }
}
