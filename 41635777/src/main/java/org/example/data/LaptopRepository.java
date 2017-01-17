package org.example.data;

import org.example.domain.Laptop;

public interface LaptopRepository extends ModelRepository<Laptop>
{
  Laptop findBySerialNumber(String serialNumber);
}
