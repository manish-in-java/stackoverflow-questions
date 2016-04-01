package org.example.data;

import org.example.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(collectionResourceRel = "organizations", path = "/organization")
@RestResource(path = "/organization", rel = "organizations")
public interface OrganizationRepository extends CrudRepository<Company, Long>
{
}
