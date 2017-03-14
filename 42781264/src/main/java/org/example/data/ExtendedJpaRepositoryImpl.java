package org.example.data;

import org.example.domain.Filter;
import org.example.domain.Model;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public class ExtendedJpaRepositoryImpl<T extends Model>
    extends SimpleJpaRepository<T, Long>
    implements ExtendedJpaRepository<T>
{
  private final EntityManager entityManager;

  public ExtendedJpaRepositoryImpl(JpaEntityInformation<T, Long> entityInformation, EntityManager entityManager)
  {
    super(entityInformation, entityManager);

    this.entityManager = entityManager;
  }

  public ExtendedJpaRepositoryImpl(final Class<T> entityClass, final EntityManager entityManager)
  {
    super(entityClass, entityManager);

    this.entityManager = entityManager;
  }

  @Override
  public T findByField(String fieldName, Object fieldValue)
  {
    return null;
  }

  @Override
  public T findByFilter(Filter<T> t)
  {
    return null;
  }
}
