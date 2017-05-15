package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("lamp")
@Entity
public class Lamp extends Product
{
  Lamp()
  {
    super();
  }

  public Lamp(final String name)
  {
    super(name);
  }
}
