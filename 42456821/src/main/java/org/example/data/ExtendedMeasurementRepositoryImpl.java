package org.example.data;

import org.example.domain.Location;
import org.example.domain.Measurement;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class ExtendedMeasurementRepositoryImpl<T extends Measurement> implements ExtendedMeasurementRepository<T>
{
  protected final EntityManager entityManager;

  private final Class<T> entityType;

  protected ExtendedMeasurementRepositoryImpl(final EntityManager entityManager, final Class<T> entityType)
  {
    this.entityManager = entityManager;
    this.entityType = entityType;
  }

  public BigDecimal findMaximumValue(final Location location)
  {
    final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
    final Root<T> root = query.from(entityType);

    query.select(builder.max(root.get("value")));
    query.where(builder.equal(root.get("location"), location));

    return entityManager.createQuery(query).getSingleResult();
  }

  public BigDecimal findMinimumValue(final Location location)
  {
    final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
    final Root<T> root = query.from(entityType);

    query.select(builder.min(root.get("value")));
    query.where(builder.equal(root.get("location"), location));

    return entityManager.createQuery(query).getSingleResult();
  }
}
