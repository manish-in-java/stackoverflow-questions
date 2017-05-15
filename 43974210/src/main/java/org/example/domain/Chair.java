package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("chair")
@Entity
public class Chair extends Product
{
  Chair()
  {
    super();
  }

  public Chair(final String name)
  {
    super(name);
  }
}
