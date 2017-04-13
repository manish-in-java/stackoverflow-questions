package org.example.data;

import org.example.domain.Bulldozer;
import org.springframework.beans.factory.annotation.Autowired;

public class BulldozerRepositoryTest extends EquipmentRepositoryTest<Bulldozer>
{
  @Autowired
  private EquipmentRepository<Bulldozer> repository;

  @Override
  protected Bulldozer getEquipment()
  {
    return new Bulldozer(getRandomString(), getRandomString(), getRandomString());
  }

  @Override
  public EquipmentRepository<Bulldozer> getRepository()
  {
    return repository;
  }
}
