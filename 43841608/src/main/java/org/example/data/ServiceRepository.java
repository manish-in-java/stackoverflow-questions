package org.example.data;

import org.example.domain.Service;

import java.util.List;

public interface ServiceRepository extends ModelRepository<Service>
{
  List<Service> findAllByCategoryAndAutoServiceServiceName(String category, String autoServiceName);
}
