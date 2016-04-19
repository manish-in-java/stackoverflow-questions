package org.example.data;

import org.example.domain.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long>
{
  @Query(nativeQuery = true, value = "select id, name from company")
  List<Company> getAll();

  @Query(nativeQuery = true, value = "select id, name from company")
  List<Object> listAll();
}
