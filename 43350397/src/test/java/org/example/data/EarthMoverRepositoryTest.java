package org.example.data;

import org.example.domain.EarthMover;
import org.springframework.beans.factory.annotation.Autowired;

public class EarthMoverRepositoryTest extends EquipmentRepositoryTest<EarthMover>
{
  @Autowired
  private EquipmentRepository<EarthMover> repository;

  @Override
  protected EarthMover getEquipment()
  {
    return new EarthMover(getRandomString(), getRandomString(), getRandomString());
  }

  @Override
  public EquipmentRepository<EarthMover> getRepository()
  {
    return repository;
  }
}
