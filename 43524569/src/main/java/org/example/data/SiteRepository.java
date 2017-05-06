package org.example.data;

import org.example.domain.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends ModelRepository<Site>
{
  @Query("SELECT s FROM Site s WHERE ?1")
  List<Site> findSites(String constraint);
}
