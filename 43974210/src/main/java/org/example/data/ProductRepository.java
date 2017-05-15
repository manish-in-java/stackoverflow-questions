package org.example.data;

import org.example.domain.Product;

public interface ProductRepository<T extends Product> extends ModelRepository<T>
{
}
