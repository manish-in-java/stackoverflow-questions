package org.example.data;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.QStock;
import org.example.domain.Stock;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface StockRepository extends ModelRepository<Stock>, QueryDslPredicateExecutor<Stock>
{
  default int findTotalQuantityByProduct(final String product)
  {
    final QStock stock = QStock.stock;

    return new JPAQuery<>().from(stock)
                           .where(stock.product.equalsIgnoreCase(product))
                           .select(stock.quantity.sum())
                           .fetchOne();
  }
}
