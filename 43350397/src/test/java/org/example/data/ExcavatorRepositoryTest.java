package org.example.data;

import org.example.domain.Excavator;
import org.springframework.beans.factory.annotation.Autowired;

public class ExcavatorRepositoryTest extends EquipmentRepositoryTest<Excavator>
{
  @Autowired
  private EquipmentRepository<Excavator> repository;

  @Override
  protected Excavator getEquipment()
  {
    return new Excavator(getRandomString(), getRandomString(), getRandomString());
  }

  @Override
  public EquipmentRepository<Excavator> getRepository()
  {
    return repository;
  }
}
