package org.example.data;

import org.example.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(collectionResourceRel = "companies", path = "/company")
@RestResource(path = "/company", rel = "companies")
public interface CompanyRepository extends CrudRepository<Company, Long>
{
}
