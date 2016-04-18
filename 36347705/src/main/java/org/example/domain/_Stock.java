package org.example.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Stock.class)
public class _Stock
{
  public static volatile SingularAttribute<Stock, String> product;

  public static volatile SingularAttribute<Stock, Integer> quantity;

  public static volatile SingularAttribute<Stock, String> reason;
}
