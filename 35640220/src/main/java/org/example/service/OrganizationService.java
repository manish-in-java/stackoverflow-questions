package org.example.service;

import org.example.data.OrganizationRepository;
import org.example.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationService
{
  @Autowired
  private OrganizationRepository repository;

  @Cacheable(key = "#id", value = "main")
  public Organization find(Long id)
  {
    return repository.findOne(id);
  }

  public List<Organization> list()
  {
    return repository.findAll();
  }

  @CacheEvict(key = "#organization.ID", value = "main")
  @Transactional
  public Organization save(Organization organization)
  {
    return repository.save(organization);
  }
}
