package org.example.data;

import org.example.domain.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, UUID>
{
}
