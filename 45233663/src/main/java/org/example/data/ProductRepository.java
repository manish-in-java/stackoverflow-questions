package org.example.data;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import org.example.domain.Product;
import org.example.domain.QProduct;
import org.example.domain.QProductAttribute;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends ModelRepository<Product>, QueryDslPredicateExecutor<Product>
{
  default List<Product> findAllByAttributes(final Map<String, String> attributes)
  {
    final QProduct root = QProduct.product;

    BooleanExpression query = root.isNotNull();

    for (final String attribute : attributes.keySet())
    {
      final QProductAttribute branch = root.attributes.any();

      final BooleanExpression subquery = branch.attribute.name.equalsIgnoreCase(attribute)
                                                              .and(branch.value.equalsIgnoreCase(attributes.get(attribute)));

      query = query.and(JPAExpressions.selectFrom(QProductAttribute.productAttribute).where(subquery).exists());
    }

    return (List<Product>) findAll(query);
  }
}
