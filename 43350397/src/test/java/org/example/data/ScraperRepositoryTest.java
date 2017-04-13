package org.example.data;

import org.example.domain.Scraper;
import org.springframework.beans.factory.annotation.Autowired;

public class ScraperRepositoryTest extends EquipmentRepositoryTest<Scraper>
{
  @Autowired
  private EquipmentRepository<Scraper> repository;

  @Override
  protected Scraper getEquipment()
  {
    return new Scraper(getRandomString(), getRandomString(), getRandomString());
  }

  @Override
  public EquipmentRepository<Scraper> getRepository()
  {
    return repository;
  }
}
