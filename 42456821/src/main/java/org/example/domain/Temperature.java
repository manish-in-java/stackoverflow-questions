package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "temperature")
public class Temperature extends Measurement
{
  Temperature()
  {
    super();
  }

  public Temperature(final Location location, final Date time, final BigDecimal value)
  {
    super(location, time, value);
  }
}
