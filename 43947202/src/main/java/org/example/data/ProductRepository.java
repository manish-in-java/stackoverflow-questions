package org.example.data;

import org.example.domain.Product;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductRepository extends ModelRepository<Product>, QueryDslPredicateExecutor<Product>
{
}
