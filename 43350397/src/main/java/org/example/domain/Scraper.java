package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Scraper extends Equipment
{
  Scraper()
  {
    super();
  }

  public Scraper(final String serialNumber, final String make, final String model)
  {
    super(serialNumber, make, model);
  }
}
