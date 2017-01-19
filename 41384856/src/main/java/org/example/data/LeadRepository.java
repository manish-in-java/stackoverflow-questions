package org.example.data;

import org.example.domain.Lead;
import org.example.domain.QLead;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface LeadRepository extends ModelRepository<Lead>, QueryDslPredicateExecutor<Lead>
{
  default Iterable<Lead> findAllByCompanyName(final String companyName)
  {
    return findAll(QLead.lead.employee.site.company.name.equalsIgnoreCase(companyName));
  }
}
