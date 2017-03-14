package org.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class ExtendedJpaRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID>
{
  @Override
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager)
  {
    return new ExtendedJpaRepositoryFactory(entityManager);
  }

  private static class ExtendedJpaRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory
  {
    ExtendedJpaRepositoryFactory(final EntityManager entityManager)
    {
      super(entityManager);
    }

    protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata)
    {
      return ExtendedJpaRepositoryImpl.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected SimpleJpaRepository<T, ID> getTargetRepository(final RepositoryMetadata metadata, final EntityManager entityManager)
    {
      return new ExtendedJpaRepositoryImpl(metadata.getDomainType(), entityManager);
    }
  }
}
