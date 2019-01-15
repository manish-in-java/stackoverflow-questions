package org.example.data;

import org.example.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends ModelRepository<Product>
{
  @Query("SELECT "
      + "    DISTINCT p.category "
      + "FROM "
      + "    Product p "
      + "WHERE "
      + "    p.customerNumber = ?1 "
      + "ORDER BY "
      + "    p.category")
  Page<Product> findDistinctCategoryByCustomerNumber(String customerNumber, Pageable pageable);
}
