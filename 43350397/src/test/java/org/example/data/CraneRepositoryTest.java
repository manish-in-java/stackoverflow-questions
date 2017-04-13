package org.example.data;

import org.example.domain.Crane;
import org.springframework.beans.factory.annotation.Autowired;

public class CraneRepositoryTest extends EquipmentRepositoryTest<Crane>
{
  @Autowired
  private EquipmentRepository<Crane> repository;

  @Override
  protected Crane getEquipment()
  {
    return new Crane(getRandomString(), getRandomString(), getRandomString());
  }

  @Override
  public EquipmentRepository<Crane> getRepository()
  {
    return repository;
  }
}
