package org.example.data;

import org.example.domain.Model;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedJpaRepository<T extends Model> extends FilteringJpaRepository<T>
{
  T findByField(String fieldName, Object fieldValue);
}
