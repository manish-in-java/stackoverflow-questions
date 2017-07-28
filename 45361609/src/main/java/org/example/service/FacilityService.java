package org.example.service;

import org.example.data.FacilityRepository;
import org.example.domain.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService
{
  @Autowired
  private FacilityRepository repository;

  Facility getOne(final Long id)
  {
    return repository.findOne(id);
  }
}
