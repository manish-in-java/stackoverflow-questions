package org.example.data;

import org.example.domain.Product;

public interface ProductRepository extends ModelRepository<Product>, CustomRepository<Product, Long>
{
}
