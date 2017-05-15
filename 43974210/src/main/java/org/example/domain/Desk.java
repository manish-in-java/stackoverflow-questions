package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("desk")
@Entity
public class Desk extends Product
{
  Desk()
  {
    super();
  }

  public Desk(final String name)
  {
    super(name);
  }
}
