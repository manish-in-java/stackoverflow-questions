package org.example.data;

import org.example.domain.Filter;
import org.example.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FilteringJpaRepository<T extends Model> extends JpaRepository<T, Long>
{
  T findByFilter(Filter<T> t);
}
